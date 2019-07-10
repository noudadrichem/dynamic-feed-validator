import { Component, Input } from '@angular/core';

@Component({
  selector: 'card-container',
  templateUrl: './card-container.component.html',
  styleUrls: ['./card-container.component.scss']
})

export class CardContainerComponent {
  @Input() errors: Array<any>
  @Input() warnings: Array<any>
  @Input() isErrorsShown: boolean
  @Input() isWarningsShown: boolean  
}
