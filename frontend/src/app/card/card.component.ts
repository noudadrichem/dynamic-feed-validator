import { Component, Input } from '@angular/core';

@Component({
  selector: 'card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent {

  @Input() title : string
  @Input() description : string
  @Input() type : string
  @Input() productId : string

  isDescriptionShown: boolean = false 

  constructor() {}

  toggleDescription(): void {
    console.log('toggleDescription')
    this.isDescriptionShown = !this.isDescriptionShown
  }

}
