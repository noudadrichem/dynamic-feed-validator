import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class FeedModelService {
  constructor() {}

  private subject = new Subject<any>();
  private feeds: Array<Object> = []

  onFeedUpdate() {
    console.log('on update feed model service')
    return this.subject.asObservable();
  }

  trigger() {
    console.log('trigger feed model service')
    this.subject.next()
  }  

  getFeeds(): Array<Object> {
    return this.feeds;
  }

  pushFeed(feed: Object) {
    this.feeds.push(feed)
  }

}
