import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import * as AppConst from '../app.const';

@Injectable({
  providedIn: 'root'
})
export class BusService {

  url : string = 'http://ec2-13-232-109-197.ap-south-1.compute.amazonaws.com:8098/rest/bus';

  constructor(private http: HttpClient) {}

  findAll() {
    return this.http.get(this.url);
  }

  saveBus(buses) {
    return this.http.post(this.url, buses);
  }


  getBussesForSrcDestDate(src, dest, date): Observable<any>{
  	return this.http.get<string>(AppConst.baseURL + AppConst.BusURL + '/rest/bus/source/'+ src +'/destination/'+ dest +'/date/'+ date );
  }

  getBusDetails(name): Observable<any>{
  	return this.http.get<string>(AppConst.baseURL + AppConst.BusURL + '/rest/bus/'+ name );
  }

  sendBusBooking(booking): Observable<any>{
    return this.http.put<any>(AppConst.baseURL + AppConst.BusURL + '/rest/bus', booking);
  }


}


