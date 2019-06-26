import { Component, OnInit } from '@angular/core';
import { Socket } from 'ngx-socket-io';
import { environment } from './../../environments/environment'
const { API_URL } = environment

@Component({
  selector: 'message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.scss']
})
export class MessageComponent implements OnInit {

  socket: WebSocket
  activeSocketSessionId: String
  
  echoText: String = ""
  connected: boolean = false;
  stilValidating: boolean = true;
  errors: Array<any> = []
  warnings: Array<any> = []

  constructor() { }

  ngOnInit() {
    this.connecSocket();
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

    if(message.type === 'init')  {
      this.activeSocketSessionId = message.id
      window.sessionStorage.setItem("sessionId", message.id)
    } else {
      this[message.type === 'error' ? 'errors' : 'warnings'].push(message)
    }
  }

  wsError(message){
    this.echoText += "Error ... \n";
  }

}
