import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';

import { UsersService } from '../../../_services/users.service';
import { BusService } from '../../../_services/bus.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-booking-complete',
  templateUrl: './booking-complete.component.html',
  styleUrls: ['./booking-complete.component.css']
})
export class BookingCompleteComponent implements OnInit {

  seatsStr: any;


  constructor(
    private _toastr: ToastrService,
    private router: Router,
    private _busService: BusService,
    private _userService: UsersService,
    private _route: ActivatedRoute) { }

  ngOnInit() {
    const seats = this._route.snapshot.paramMap.get('seats');

    this.seatsStr = seats;

  }



  errorMsg(msg) {
    this._toastr.error(msg, '', {
      timeOut: 5000,
      enableHtml: true,
      toastClass: 'alert alert-danger alert-with-icon',
      positionClass: 'toast-top-center'
    });
  }

  successMsg(msg) {
    this._toastr.error(msg, '', {
      timeOut: 5000,
      enableHtml: true,
      toastClass: 'alert alert-success alert-with-icon',
      positionClass: 'toast-top-center'
    });
  }

}
