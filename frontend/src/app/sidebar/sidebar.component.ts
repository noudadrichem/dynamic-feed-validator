import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../environments/environment';
const { API_URL } = environment

@Component({
  selector: 'sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {

  feeds: any = [];

  constructor(private http: HttpClient) {}

  async ngOnInit() {
    this.http.get(`${API_URL}/feed/all`)
      .subscribe(allFeeds => {
        this.feeds = allFeeds;
      })
  }

  selectFeed(feedId: String): void {
    console.log('select', feedId)
  }

}
