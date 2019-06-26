import { Component, OnInit } from '@angular/core'
import { HttpClient } from '@angular/common/http'
import { ActivatedRoute } from '@angular/router'
import { environment } from './../../environments/environment'
const { API_URL } = environment

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})

export class HomeComponent implements OnInit {

  feed: any = {}
  errors: Array<any> = []
  warnings: Array<any> = []
  isFeedIsSelected: boolean = false
  isErrorsShown: boolean = true
  isWarningsShown: boolean = true
  isSettingsIsShown: boolean = false

  constructor(
    private http: HttpClient,
    private route: ActivatedRoute
    ) {}

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      const feedId = params.get('feedid')
      if(feedId !== null) {
        this.getSelectedFeed(feedId)
        this.isFeedIsSelected = true;
      }
    })
  }

  getSelectedFeed(feedId: string): any {
    this.http.get(`${API_URL}/feed/${feedId}`)
      .subscribe(feed => {
        this.feed = feed

        this.errors = this.feed.messages.filter(m => m.type === 'error')
        this.warnings = this.feed.messages.filter(m => m.type === 'warning')
      })
  }

  showErrors(): void {
    this.isErrorsShown = true;
    this.isWarningsShown = false;
  }
  showWarnings(): void {
    this.isWarningsShown = true;
    this.isErrorsShown = false;
  }
  
  showAllMessages(): void {
    this.isErrorsShown = true;
    this.isWarningsShown = true;
  }

  hideSettingsModal() {
    console.log('hide')
    this.isSettingsIsShown = false
  }
  showSettingsModal() {
    console.log('show')
    this.isSettingsIsShown = true
  }

}
