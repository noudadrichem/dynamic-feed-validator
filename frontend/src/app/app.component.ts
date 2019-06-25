import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent {

  constructor() {}

  listenToUploadedFeed(): void {
    console.log('feed has beeen uploaded a zabii')
  }

}
