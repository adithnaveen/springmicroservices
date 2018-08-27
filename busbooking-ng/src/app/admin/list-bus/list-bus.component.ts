import { Component, OnInit } from '@angular/core';
import { BusService } from '../../_services/bus.service';

@Component({
  selector: 'app-list-bus',
  templateUrl: './list-bus.component.html',
  styleUrls: ['./list-bus.component.css']
})
export class ListBusComponent implements OnInit {

  buses = [];

  constructor(private busService: BusService) { }

  ngOnInit() {
    
    this.busService.findAll().subscribe(
      (buses: any[]) => { 
        console.log(buses);
        this.buses = buses;
      },
      (error) => console.log(error)
      
    );

  }

  
  

}



