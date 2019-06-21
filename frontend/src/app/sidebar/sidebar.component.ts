import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../environments/environment';
import { ActivatedRoute } from '@angular/router'
const { API_URL } = environment

@Component({
  selector: 'sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {

  feeds: any = [];
  currentlySelectedFeed = "";

  constructor(
    private http: HttpClient,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.http.get(`${API_URL}/feed/all`)
      .subscribe(allFeeds => {
        this.feeds = allFeeds;
      })

    this.route.paramMap.subscribe(params => {
      this.currentlySelectedFeed = params.get('feedid')
      console.log(params.get('feedid'))
    })
  }

  deleteFeed(feedId): void {
    console.log(feedId)
    this.http.delete(`${API_URL}/feed/delete/${feedId}`)
      .subscribe(data => {
        console.log({ data })
        this.feeds = this.feeds.filter(f => f.id !== feedId)
      })
  }

}
