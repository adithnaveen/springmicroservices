import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { BusService } from '../../_services/bus.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-bus',
  templateUrl: './add-bus.component.html',
  styleUrls: ['./add-bus.component.css']
})
export class AddBusComponent implements OnInit {

  buses = {};
  busTypes = ['Multi Axle', 'Rear Engine'];

  defaultsrc = 'Bangalore';
  defaultdest = 'Mysore';

  constructor(private busService: BusService, private router: Router) { }

  ngOnInit() {
  }

  onAddBus(form: NgForm) {

    this.buses = {

      busTitle: form.value.busname,
      totalNoOfSeats: form.value.totalseats,
      noOfSeatsAvailable: form.value.totalseats,
      busType: form.value.bustype,
      busTravelDate: form.value.bustraveldate,
      busTravelTime: form.value.bustraveltime,
      busSource: form.value.bussource,
      busDestination: form.value.busdestination,
      costPerSeat: form.value.costperseat,

    };

    this.busService.saveBus(this.buses).subscribe(
      (data) => {
        console.log(data);
        this.router.navigate(['/admin/listbus']);
      },
      (error) => console.log(error)
      
    );
  }

}

