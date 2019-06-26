import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../environments/environment';
const { API_URL } = environment

@Component({
  selector: 'settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.scss']
})
export class SettingsComponent implements OnInit {

  @Input() feedId: Function
  @Output() emitter = new EventEmitter();

  constructor(private http: HttpClient) { }

  ngOnInit() {}

  hideModal() {
    this.emitter.emit(false);
  }

  deleteFeed(): void {

    this.http.delete(`${API_URL}/feed/delete/${this.feedId}`)
      .subscribe(data => {
        console.log({ data })
      })
  }

}
