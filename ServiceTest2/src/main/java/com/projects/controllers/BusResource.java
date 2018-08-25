package com.projects.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.model.Bus;
import com.projects.model.TicketBooking;
import com.projects.service.BusBookingService;

@CrossOrigin(origins={"http://localhost:4200", "http://localhost:8098"}, maxAge=3600)
@RestController
@RequestMapping("/rest")
public class BusResource {
	@Autowired
	private BusBookingService busBookingService;
	
	@GetMapping("/bus")
	public List<Bus> getAllBusses(){
		return busBookingService.getAllBusses(); 
	}
	
	@GetMapping("/bus/{busName}")
	public Bus getBusByName(@PathVariable String busName){
		return busBookingService.getBus(busName); 
	}
	
	@PostMapping("/bus")
	public Bus create(@RequestBody Bus bus){
		return busBookingService.create(bus); 
	}
	
	@GetMapping("/bus/travel/src/{source}")
	public List<Bus> getBusBySource(@PathVariable String source){
		return busBookingService.getBusBySource(source); 
	}
	
	@GetMapping("/bus/travel/dest/{destination}")
	public List<Bus> getBusByDestination(@PathVariable String destination){
		return busBookingService.getBusByDestination(destination);  
	}
	
	// this method is used to find the bookings done by particular user 
	@GetMapping("/bus/bookings/{email}")
	public List<Bus> getBookingsForBus(@PathVariable String email){
		System.out.println("booking finding for [getBookingsForBus]:  " + email);
		return busBookingService.getBussesForEmail(email);
	}
	
	// get busses based on source, destination and date  when user enters for searching 
	// this method returns busname, no_of_seats available, total_number_of_seats 
	// time, cost per seat 
	@GetMapping("/bus/source/{source}/destination/{destination}/date/{busTravelDate}")
	public List<Bus> getBussesForSourceDestinationDate(
			@PathVariable String source, 
			@PathVariable String destination, 
			@PathVariable String busTravelDate){

			return busBookingService.getBussesForSourceDestinationDate(source, destination, busTravelDate);
	}
	
	
	
	/*String busTitle, int numberOfSeats, String email, 
	String paymentMode, String creditCardNumber, int expiryYear, 
	int expiryMonth
	*/
	
	/**
	 * 
	 * @param ticketBooking
	 * @return List<Integer>
	 * @see ticket confirmation, which shall update the bus collection, add's a new booking
			and returns the ticket numbers booked by the user 
	 */
	
	@PutMapping("/bus")
	public List<Integer> bookTicketsForBus(@RequestBody TicketBooking ticketBooking){
		return busBookingService.bookTicketsForBus(ticketBooking); 
	}

	
	
	
}
