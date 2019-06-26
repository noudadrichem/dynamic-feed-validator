import { Component, Input } from '@angular/core';

@Component({
  selector: 'card-container',
  templateUrl: './card-container.component.html',
  styleUrls: ['./card-container.component.scss']
})
export class CardContainerComponent {

  @Input() errors: Array<any>
  @Input() warnings: Array<any>

  isErrorsShown: boolean = true
  isWarningsShown: boolean = true

  constructor() { }

  toggleErrorShown(): void { this.isErrorsShown = !this.isErrorsShown; }
  toggleWarningsShown(): void { this.isWarningsShown = !this.isWarningsShown; }

  
}
