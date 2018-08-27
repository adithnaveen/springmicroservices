import { Component, OnInit } from '@angular/core';
import * as AppConst from '../app.const';

import { UsersService } from '../_services/users.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private _userService: UsersService) { }

  ngOnInit() {
  }

}
