import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { ToastrService } from 'ngx-toastr';

import { UsersService } from '../../../_services/users.service';
import { BusService } from '../../../_services/bus.service';

@Component({
  selector: 'app-seat-selection',
  templateUrl: './seat-selection.component.html',
  styleUrls: ['./seat-selection.component.css']
})
export class SeatSelectionComponent implements OnInit {

  busDetails: any;
  isLoading: boolean = true;
  busPrice: number;
  totalPrice: number;
  availSeats: number;
  booking: any;

  constructor(
  	private _toastr: ToastrService,
  	private _router: Router,
  	private _userService: UsersService,
  	private _busService: BusService,
  	private _route: ActivatedRoute) { }

  ngOnInit() {

  	const busName = this._route.snapshot.paramMap.get('busname');

  	this._busService.getBusDetails(busName).subscribe(bus => {
  		if(!bus){
  			this.errorMsg('Oops! Something Wrong Try Again');
  			this.isLoading = false;
  		} else {
  			this.availSeats = bus.noOfSeatsAvailable;
  			this.busPrice = bus.costPerSeat;
  			this.isLoading = false;
  			this.successMsg('Please select no of Seats');
  			this.busDetails = bus;
  		}
  	})

  }


  onNoOfSeatChange(value){
  	if(this.availSeats < value){
  		this.errorMsg(value + ' seats are not available');
  	}
  	this.totalPrice = (this.busPrice * value);
  }

  onSubmit({value, valid}: {value: any, valid: boolean}){
    if(!valid){
      this.errorMsg('Enter all details correctly');
    } else {
      this.booking = {
        busTitle: this.busDetails.busTitle,
        creditCardNumber: localStorage.getItem('userCardNo'),
        email: localStorage.getItem('userEmail'),
        expiryMonth: parseInt(localStorage.getItem('userCardExpDate').substring(0,2)),
        expiryYear: parseInt(localStorage.getItem('userCardExpDate').substring(2,6)),
        numberOfSeats: parseInt(value.noofseats),
        paymentMode: 'credit'
      }
      this._busService.sendBusBooking(this.booking).subscribe(result => {
        console.log(result);
        this.successMsg('Booking Success');
        this._router.navigate([result+'/booking-complete']);
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
