import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';

import { UsersService } from '../../_services/users.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(
  	private _toastr: ToastrService,
  	private router: Router,
  	private _userService: UsersService) { }

  ngOnInit() {
    this._userService.checkAuth();
  }

  onSubmit({value, valid}: { value: any, valid: boolean }) {
  	if(!valid){
  		this.errorMsg('Enter all details correctly');
  	} else {
  		this._userService.loginUser(value).subscribe(result => {
  			if(!result){
  				this.errorMsg('Incorrect Credentials');
  			} else {
  				this._userService.getUserByEmail(value.email).subscribe((user: any) => {
  					this.successMsg('Login Success');
            localStorage.setItem('authUserType', 'User');
            localStorage.setItem('userEmail', user.email);
            localStorage.setItem('userCardNo', user.payment.cardNumber);
	  				localStorage.setItem('userCardExpDate', user.payment.cardExpMonthYear);
	  				this.router.navigate(['/bookings']);
  				})
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




