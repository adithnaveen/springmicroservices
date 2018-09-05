import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import * as AppConst from '../app.const';


@Injectable({
  providedIn: 'root'
})
export class UsersService {

  baseUrl = 'http://localhost:8877';

  email: string;

  constructor(private http: HttpClient) { }

  addUsers(users) {
    return this.http.post(this.baseUrl + '/rest/user/register', users);
  }

  loginUser(value): Observable<any> {

    const base64Credential: string = btoa(value.email + ':' + value.password);

    this.email = value.email;

    localStorage.setItem('authCode', base64Credential);

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Basic ' + base64Credential
      })
    };

    return this.http.get<any>(this.baseUrl + '/rest/user/email/' + value.email + '/password/' + value.password, httpOptions);
  }

  getUserByEmail(email): Observable<string> {

    const authCode = localStorage.getItem('authCode');

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Basic ' + authCode
      })
    };

    return this.http.get<string>(this.baseUrl + '/rest/user/' + email, httpOptions);
  }

  // checkauth
  checkAuth() {

    if (localStorage.getItem('userEmail')) {
      return true;
    } else {
      return false;
    }


  }

}






