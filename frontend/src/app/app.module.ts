import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { MessageComponent } from './message/message.component';
import { LoginComponent } from './login/login.component';
import { ContainerComponent } from './container/container.component';
import { HomeComponent } from './home/home.component';
import { UploadComponent } from './upload/upload.component';
import { CardComponent } from './card/card.component';

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
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
