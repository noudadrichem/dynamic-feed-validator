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
    this.fetchFeeds()
  }

  fetchFeeds(): void {
    this.http.get(`${API_URL}/feed/all`)
      .subscribe(allFeeds => {
        this.feeds = allFeeds;
      })

    this.route.paramMap.subscribe(params => {
      this.currentlySelectedFeed = params.get('feedid')
      console.log(params.get('feedid'))
    })
  }

}
