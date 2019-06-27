import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable} from 'rxjs';
import { environment } from '../../environments/environment';
const { API_URL } = environment

@Injectable({ providedIn: 'root'})
export class FeedHttpService {

  constructor(private http: HttpClient) {}

  uploadFeedUrl(body): Observable<any> {
    return this.http.post(`${API_URL}/feed/upload`, body)
  }

  getSelectedFeed(feedId: String): Observable<any> {
    return this.http.get(`${API_URL}/feed/${feedId}`)
  }

  fetchFeeds(): Observable<any> {
    return this.http.get(`${API_URL}/feed/all`)
  }

  deleteFeed(feedId: String): Observable<any> {
    return this.http.delete(`${API_URL}/feed/delete/${feedId}`)
  }

  fetchFeedBluePrint(feedId: String): Observable<any> {
    return this.http.get(`${API_URL}/blueprint/${feedId}`)
  }
}
