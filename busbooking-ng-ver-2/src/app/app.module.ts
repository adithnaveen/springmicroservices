import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RoutingModule } from './routing.module';
import { ToastrModule } from 'ngx-toastr';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AuthComponent } from './auth/auth.component';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { AdminComponent } from './admin/admin.component';
import { AddBusComponent } from './admin/add-bus/add-bus.component';
import { ListBusComponent } from './admin/list-bus/list-bus.component';

import { UsersService } from './_services/users.service';
import { BusService } from './_services/bus.service';
import { BookingsComponent } from './components/bookings/bookings.component';
import { BookingsBusListComponent } from './components/bookings/bookings-bus-list/bookings-bus-list.component';
import { SeatSelectionComponent } from './components/bookings/seat-selection/seat-selection.component';
import { BookingCompleteComponent } from './components/bookings/booking-complete/booking-complete.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AuthComponent,
    HomeComponent,
    PageNotFoundComponent,
    LoginComponent,
    RegisterComponent,
    AdminComponent,
    AddBusComponent,
    ListBusComponent,
    BookingsComponent,
    BookingsBusListComponent,
    SeatSelectionComponent,
    BookingCompleteComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    RoutingModule,
    ToastrModule.forRoot()
  ],
  providers: [UsersService, BusService],
  bootstrap: [AppComponent]
})
export class AppModule { }

