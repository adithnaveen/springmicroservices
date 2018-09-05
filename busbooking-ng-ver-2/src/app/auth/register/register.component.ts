import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UsersService } from '../../_services/users.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  users = {};
  genders = ['Male', 'Female'];
  enable = true;
  role = 'ADMIN';

  constructor(
    private usersService: UsersService,
    private router: Router) { }

  ngOnInit() {
  }

  onRegister(form: NgForm) {

    this.users = {
      email: form.value.email,
      enabled: this.enable,
      gender: form.value.gender,
      name: {
        firstName: form.value.fname,
        lastName: form.value.lname
      },
      password: form.value.password,
      role: this.role,
      payment: {
        cardExpMonthYear: form.value.expiration,
        cardNumber: form.value.cardno
      }
    };

    this.usersService.addUsers(this.users).subscribe(
      (response) => {
        console.log(response);
        this.router.navigate(['/login']);
      },
      (error) => console.log(error)
    );
  }

}








