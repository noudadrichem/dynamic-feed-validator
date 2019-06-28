import { Component, OnInit } from '@angular/core';
import { FeedHttpService } from '../services/feed-http.service'
import { FeedModelService } from '../services/feed-model.service'
import { environment } from '../../environments/environment';
import { ActivatedRoute } from '@angular/router';
import { map } from 'rxjs/operators';
const { SOCKET_URL } = environment

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.scss']
})
export class UploadComponent implements OnInit {

  socket: WebSocket
  activeSocketSessionId: String

  inputUrl: String = 'https://werk.noudadrichem.com/feed-validator/benchy-bad-feed.xml'
  isUploadSuccess: boolean = false;
  submitted: boolean = false;  
  echoText: String = ''
  connected: boolean = false;
  isStilValidating: boolean = false;
  errors: Array<any> = []
  warnings: Array<any> = []

  constructor(
    private feedHttpService: FeedHttpService,
    private feedModelService: FeedModelService,
    public activatedRoute: ActivatedRoute
    ) {}

  ngOnInit() {
    this.connecSocket();

    // this.feedModelService.onUploadUpdate()
    //   .subscribe(url => {
    //     console.log('upload url', url)
    //   })

    // this.inputUrl = this.activatedRoute.paramMap
    //   .pipe(map(() => window.history.state.url))
 
    this.activatedRoute.paramMap.pipe(map(ja => window.history.state.url))
      .subscribe(url => {
        if(url !== undefined) {
          this.inputUrl = url
          this.startValidation()
        }
      })
      
  }

  resetUI() {
    this.errors = []
    this.warnings = []
    this.isStilValidating = false
  }

  startValidation() {
    this.resetUI()
    this.isStilValidating = true

    const body: Object = {
      url: this.inputUrl,
      validationId: 'id',
      socketSessionId: window.sessionStorage.getItem('sessionId')
    }

    this.feedHttpService.uploadFeedUrl(body)
      .subscribe((data) => {
        this.isUploadSuccess = data['success'];
        this.submitted = true;

        setTimeout(() => {
          this.submitted = false
        }, 3200)
      })
  }

  connecSocket(): void {
    console.log('trying to connect')

    this.socket = new WebSocket(SOCKET_URL)

    this.socket.onopen = () => this.webSocketOpen()
    this.socket.onclose = () => this.webSocketClose()
    this.socket.onmessage = (message) => this.webSocketGetMessage(message)
    this.socket.onerror = (message) => this.webSocketError(message)
  } 

  webSocketOpen() {
    console.log('connected')
    this.connected = true
  }

  wsSendMessage() {
    this.socket.send('is client connected?')
  }

  webSocketCloseConnection() {
    this.socket.close();
    this.connected = false
  }

  webSocketClose() {
    console.log('Disconnected')
    this.connected = false
  }

  webSocketGetMessage(message) {
    message = JSON.parse(message.data)
    console.log(message)
    
    switch(message.type) {
      case('init'):
        this.activeSocketSessionId = message.id
        window.sessionStorage.setItem('sessionId', message.id)
        break;
      case 'finale':
        this.isStilValidating = false
        // TODO: feedModelService push feed from finale message from socket.
        this.feedModelService.fetchTrigger();
        break;
      case 'error':
        this.errors.push(message) 
        break;
      case 'warning':
        this.warnings.push(message)
    }
  }

  webSocketError(message) {
    console.log('socket error...', { message })
  }
}