import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../environments/environment';
import { ActivatedRoute } from '@angular/router';
const { API_URL } = environment

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  feed: Object = {}

  constructor(
    private http: HttpClient,
    private route: ActivatedRoute
    ) {}

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      const feedId = params.get('feedid')
      if(feedId !== null) {
        this.getSelectedFeed(feedId)
      }
    });
  }

  getSelectedFeed(feedId: string): void {
     this.http.get(`http://localhost:9090/api/feed/${feedId}`)
      .subscribe(feed => {
        this.feed = feed;
      })
  }

}
