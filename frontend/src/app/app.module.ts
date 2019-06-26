import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { SocketIoModule, SocketIoConfig } from 'ngx-socket-io';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { MessageComponent } from './message/message.component';
import { LoginComponent } from './login/login.component';
import { ContainerComponent } from './container/container.component';
import { HomeComponent } from './home/home.component';
import { UploadComponent } from './upload/upload.component';
import { CardComponent } from './card/card.component';

const socketConfig: SocketIoConfig = {
  url: 'http://localhost:9090/api/feed/subscribe'
}

@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    MessageComponent,
    LoginComponent, 
    ContainerComponent,
    HomeComponent,
    UploadComponent,
    CardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    SocketIoModule.forRoot(socketConfig)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
