import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router'
import { FeedHttpService } from '../services/feed-http.service' 
import { FeedModelService } from '../services/feed-model.service' 

@Component({
  selector: 'settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.scss']
})
export class SettingsComponent implements OnInit {

  @Input() feedId: String
  @Input() feedName: String
  @Input() feedUrl: String
  @Input() totalAmount: Number
  @Output() emitter = new EventEmitter();

  keys: Array<String> = []
  isDeleteFeedShown: boolean = false
  feedNameLocal: String

  constructor(
    private feedHttpService: FeedHttpService,
    private feedModelService: FeedModelService,
    private router: Router
  ) {}

  ngOnInit() {
    this.fetchBluePrint()
    this.feedNameLocal = this.feedName
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

  saveChanges(): void {
    const body: Object = {
      title: this.feedNameLocal
    }
    this.feedHttpService.updateFeed(this.feedId, body)
      .subscribe(data => {
        if(data.success) {
          this.hideModal()
          this.feedModelService.trigger();
        }
      })
  }

}
