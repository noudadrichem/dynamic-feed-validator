import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class FeedModelService {
  constructor() {}

  private fetchSubject = new Subject<any>();
  private uploadSubject = new Subject<any>();
  private feeds: Array<Object> = []

  onFeedUpdate(): Observable<any> {
    return this.fetchSubject.asObservable()
  }

  onUploadUpdate(): Observable<any> {
    return this.uploadSubject.asObservable()
  }

  fetchTrigger() {
    this.fetchSubject.next()
  }

  uploadTrigger(url) {
    console.log('upload trigger', url)
    this.uploadSubject.next({ url })
  }

  getFeeds(): Array<Object> {
    return this.feeds;
  }

  pushFeed(feed: Object) {
    this.feeds.push(feed)
  }

}
