import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../environments/environment';
const { API_URL } = environment


// source: https://stackoverflow.com/questions/105034/create-guid-uuid-in-javascript
function uuidv4() {
  return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, (c) => {
    var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
    return v.toString(16);
  });
}

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.scss']
})
export class UploadComponent implements OnInit {

  socket: WebSocket
  activeSocketSessionId: String

  inputUrl: String = "https://werk.noudadrichem.com/feed-validator/benchy-bad-feed.xml"
  isUploadSuccess: boolean = false;
  submitted: boolean = false;  
  echoText: String = ""
  connected: boolean = false;
  stilValidating: boolean = true;
  errors: Array<any> = []
  warnings: Array<any> = []

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.connecSocket();
  }

  resetUI() {
    this.errors = []
    this.warnings = []
    this.stilValidating = true;
  }

  startValidation() {
    this.resetUI()

    const body = {
      url: this.inputUrl,
      validationId: uuidv4(),
      socketSessionId: window.sessionStorage.getItem("sessionId")
    }

    this.http.post(`${API_URL}/feed/upload`, body)
      .subscribe((data) => {
        this.isUploadSuccess = data['success'];
        this.submitted = true;

        setTimeout(() => {
          this.submitted = false
        }, 3000)
      })
  }

  connecSocket(): void {
    console.log('trying to connect')
    this.socket = new WebSocket('ws://localhost:9090/socket');
    this.socket.onmessage = evt => {
      console.log(evt.data);
    }

    this.socket.onopen = () => { this.wsOpen();};
    this.socket.onmessage = (message) => { this.wsGetMessage(message);};
    this.socket.onclose = (message) => { this.wsClose(message);};
    this.socket.onerror = (message) => { this.wsError(message);};
  } 

  wsOpen(){
    this.connected = true
  }

  wsSendMessage(){
    this.socket.send("echo send from client")
    this.echoText = "message has been send"
    // this.echoText += "Message sended to the server : " + message.value + "\n";
    // message.value = "";
  }

  wsCloseConnection(){
    this.socket.close();
  }

  wsClose(message){
    this.echoText += "Disconnect ... \n";
  }

  wsGetMessage(message){
    message = JSON.parse(message.data)
    console.log(message)
    
    switch(message.type) {
      case('init'):
        this.activeSocketSessionId = message.id
        window.sessionStorage.setItem("sessionId", message.id)
        break;
      case 'finale':
        this.stilValidating = false
        break;
      case 'error':
        this.errors.push(message)
        break;
      case 'warning':
        this.warnings.push(message)
    }
  }

  wsError(message){
    this.echoText += "Error ... \n";
  }


}