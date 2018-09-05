import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-bookings-bus-list',
  templateUrl: './bookings-bus-list.component.html',
  styleUrls: ['./bookings-bus-list.component.css']
})
export class BookingsBusListComponent implements OnInit {

  @Input() busbookingsListArr: any[];
  @Input() source: string;
  @Input() destination: string;
  @Input() travelDate: any;

  constructor() { }

  ngOnInit() {
  }

}
