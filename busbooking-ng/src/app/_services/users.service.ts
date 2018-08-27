import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import * as AppConst from '../app.const';


@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private http: HttpClient) { }

  addUsers(users) {
    return this.http.post(AppConst.baseURL + AppConst.UserURL +'/rest/user', users);
  }


  loginUser(value): Observable<any>{
  	return this.http.get<any>(AppConst.baseURL + AppConst.UserURL + '/rest/user/email/'+ value.email +'/password/' + value.password);
  }

  getUserByEmail(email): Observable<string>{
  	return this.http.get<string>(AppConst.baseURL + AppConst.UserURL + '/rest/user/'+ email );
  }

  //checkauth
  checkAuth(){
    
    if(localStorage.getItem('authUserType') == "User"){
      return true;
    } else {
      return false;
    }


  }

}




