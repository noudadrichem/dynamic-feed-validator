import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
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
  ) {}

  ngOnInit() {
    this.fetchBluePrint()
    this.feedNameLocal = this.feedName
  }

  hideModal() {
    this.emitter.emit(false);
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
          this.feedModelService.fetchTrigger();
        }
      })
  }

}
