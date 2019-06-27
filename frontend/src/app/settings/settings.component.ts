import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router'
import { FeedHttpService } from '../services/feed-http.service' 

@Component({
  selector: 'settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.scss']
})
export class SettingsComponent implements OnInit {

  @Input() feedId: String
  @Input() totalAmount: Number
  @Output() emitter = new EventEmitter();

  keys: Array<String> = []
  isDeleteFeedShown: boolean = false

  constructor(
    private feedHttpService: FeedHttpService,
    private router: Router
  ) {}

  ngOnInit() {
    this.fetchBluePrint()
  }

  hideModal() {
    this.emitter.emit(false);
  }

  deleteFeed(): void {
    this.feedHttpService.deleteFeed(this.feedId)
      .subscribe(data => {
        console.log(data)
        this.router.navigate(['/upload'])
      })
  }

  fetchBluePrint(): void {
    this.feedHttpService.fetchFeedBluePrint(this.feedId)
      .subscribe(blueprintData => {
        this.keys = blueprintData['keys']
      })
  }

}
