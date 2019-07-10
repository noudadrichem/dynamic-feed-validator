import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router'
import { FeedHttpService } from '../services/feed-http.service'
import { FeedModelService } from '../services/feed-model.service'

@Component({
  selector: 'sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {

  feeds: any = [];
  currentlySelectedFeed = "";

  constructor(
    private route: ActivatedRoute,
    private feedHttpService: FeedHttpService,
    private feedModelService: FeedModelService
  ) {}

  ngOnInit() {
    this.fetchFeeds()

    this.feedModelService.onFeedUpdate()
      .subscribe(data => {
        this.fetchFeeds()
      })
  }

  fetchFeeds(): void {
    this.feedHttpService.fetchFeeds()
      .subscribe(allFeeds => {
        this.feeds = allFeeds;
      })

    this.route.paramMap.subscribe(params => this.currentlySelectedFeed = params.get('feedid'))
  }
}
