import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';

import { UsersService } from '../../_services/users.service';
import { BusService } from '../../_services/bus.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-bookings',
  templateUrl: './bookings.component.html',
  styleUrls: ['./bookings.component.css']
})
export class BookingsComponent implements OnInit {

  busListArr: any[] = [];
  source: string;
  destination: string;
  travelDate: any;
  isLoading: boolean;
  showList: boolean = false;

  constructor(
  	private _toastr: ToastrService,
  	private router: Router,
  	private _busService: BusService,
  	private _userService: UsersService) { }

  ngOnInit() {
  }

  onSubmit({value, valid}: {value: any, valid: boolean}){
  	if(!valid){
  		this.errorMsg('Enter all details correctly');
  	} else {
      this.isLoading = true;
  		this._busService.getBussesForSrcDestDate(value.from, value.to, value.bustraveldate).subscribe(result => {
        if(!result.length){
          this.isLoading = false;
          this.showList = false;
          this.busListArr = result;
          this.errorMsg('No Buses found for this date.');
        } else {
          this.isLoading = false;
          this.showList = true;
          this.successMsg(result.length + ' Bus(s) Found');
          this.source = result[0].busSource;
          this.destination = result[0].busDestination;
          this.travelDate = result[0].busTravelDate;
          this.busListArr = result;
        }
  		})
  	}
  }

  errorMsg(msg){
  	this._toastr.error(msg, '', {
       	timeOut: 5000,
       	enableHtml: true,
       	toastClass: "alert alert-danger alert-with-icon",
       	positionClass: 'toast-top-center'
    });
  }

  successMsg(msg){
  	this._toastr.error(msg, '', {
       	timeOut: 5000,
       	enableHtml: true,
       	toastClass: "alert alert-success alert-with-icon",
       	positionClass: 'toast-top-center'
    });
  }

}
