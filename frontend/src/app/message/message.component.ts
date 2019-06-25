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

  socket: WebSocket = new WebSocket(`${API_URL.replace('http', 'ws')}/message/1`);

  constructor() { }

  ngOnInit() {
    this.connecSocket();
  }


  connecSocket(): void {
    this.socket.onmessage = evt => {
      console.log(evt.data);
    }

  } 

}
