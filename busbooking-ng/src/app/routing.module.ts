import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { AdminComponent } from './admin/admin.component';
import { AddBusComponent } from './admin/add-bus/add-bus.component';
import { ListBusComponent } from './admin/list-bus/list-bus.component';


import { BookingsComponent } from './components/bookings/bookings.component';
import { SeatSelectionComponent } from './components/bookings/seat-selection/seat-selection.component';
import { BookingCompleteComponent } from './components/bookings/booking-complete/booking-complete.component';
import { AuthGuardService } from './_services/auth-guard.service';


const appRoutes: Routes = [
  { path: '', component: HomeComponent },
  
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  
  { path: 'admin', component: AdminComponent },
  { path: 'admin/addbus', component: AddBusComponent },
  { path: 'admin/listbus', component: ListBusComponent },

  { path: 'bookings', component: BookingsComponent, canActivate: [AuthGuardService] },
  { path: ':busname/seat-selection', component: SeatSelectionComponent, canActivate: [AuthGuardService] },
  { path: ':seats/booking-complete', component: BookingCompleteComponent, canActivate: [AuthGuardService] },


  { path: 'page-not-found', component: PageNotFoundComponent },
  { path: '**', redirectTo: '/page-not-found'}
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [RouterModule]
})
export class RoutingModule { }

