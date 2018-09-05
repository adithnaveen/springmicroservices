import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { UsersService } from '../_services/users.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(
    private _router: Router,
    private _userService: UsersService) { }

  ngOnInit() {

  }

  isAuthenticated() {
    return this._userService.checkAuth();
  }

  onLogout() {
    // localStorage.removeItem('authUserType');
    localStorage.clear();
    this._router.navigate(['/login']);
  }

}


