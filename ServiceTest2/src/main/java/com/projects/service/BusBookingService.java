package com.projects.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projects.model.Booking;
import com.projects.model.Bus;
import com.projects.model.TicketBooking;
import com.projects.repository.BusRepository;


/**
 * 
 * @author Naveen
 *
 */
@Service
public class BusBookingService {
	@Autowired
	private BusRepository busRepository; 


	
	public Bus create(Bus bus){
		return busRepository.save(bus); 
	}
	
	public List<Bus> getAllBusses(){
		return busRepository.findAll(); 
	}
	
	public Bus getBus(String busName){
		return busRepository.findByBusTitle(busName);
	}
	
	public List<Bus> getBusBySource(String src){
		return busRepository.findByBusSource(src); 
	}
	
	public List<Bus> getBusByDestination(String destination){
		return busRepository.findByBusDestination(destination); 
	}
	
//	public List<Booking> findByBookings(String name){
//		return busRepository.findByBookings(name); 
//	}
	
	
	// The list of services for getting the booking information 
	// given the user email we have to get all the busses which he has booked 
	public List<Bus> getBussesForEmail(String email){
		return busRepository.findByBussesForEmail(email); 
	}

	// get busses based on source, destination and date  when user enters for searching 
	// this method returns busname, no_of_seats available, total_number_of_seats 
	// time, cost per seat 
	public List<Bus> getBussesForSourceDestinationDate(String source, String destination, String busTravelDate){

		System.out.println("Date got for  [getBussesForSourceDestinationDate ] : " + busTravelDate);
		return busRepository.findBySourceDestinationDate(source, destination, busTravelDate); 
	}
	
	
	
	
	
	
	
	
	
	

	
	
	// ticket confirmation, which shall update the bus collection, add's a new booking
	// and returns the ticket numbers booked by the user 
	
	/*
	 * 			String busTitle, int numberOfSeats, String email, 
			String paymentMode, String creditCardNumber, int expiryYear, 
			int expiryMonth 
	 */
	
	
	public List<Integer> bookTicketsForBus(TicketBooking ticketBooking){
		System.out.println("in bookTicketsForBus - line 1 ");
		System.out.println("[findByBusTitle ] : "+  getBus(ticketBooking.getBusTitle()));		
		System.out.println("in bookTicketsForBus - line 2 ");
		
		Bus currentBusWithBookings = getBus(ticketBooking.getBusTitle()); 

		Booking currentBooking = new Booking(); 
		
		currentBooking.setBookingEmail(ticketBooking.getEmail());
		currentBooking.setNoOfSeats(ticketBooking.getNumberOfSeats());
		currentBooking.setTotalCost(ticketBooking.getNumberOfSeats() 
								* currentBusWithBookings.getCostPerSeat());
		
		currentBooking.setPaymentMethod(ticketBooking.getPaymentMode()); 
		currentBooking.setCreditCardNumber(ticketBooking.getCreditCardNumber());
		currentBooking.setExpiryYear(ticketBooking.getExpiryYear());
		currentBooking.setExpiryMonth(ticketBooking.getExpiryMonth());
		
		int seatStartingNumber = currentBusWithBookings.getTotalNoOfSeats() - 
				currentBusWithBookings.getNoOfSeatsAvailable(); 
		
		List<Integer> seatNumbers = new ArrayList<Integer>(); 
		
		for(int i=0; i<ticketBooking.getNumberOfSeats(); i++){
			seatNumbers.add(++seatStartingNumber); 
		}
		
		currentBooking.setTicketNumbers(seatNumbers);
		currentBusWithBookings.setNoOfSeatsAvailable(
				currentBusWithBookings.getNoOfSeatsAvailable()-ticketBooking.getNumberOfSeats());

		
		List<Booking> newBooking  = new ArrayList<>(); 
		
		// to avoid null pointer exception 
		if(currentBusWithBookings.getBookings()!=null){
			for(Booking tempBooking: currentBusWithBookings.getBookings()){
				newBooking.add(tempBooking); 
			}
		}
		newBooking.add(currentBooking); 
		
		currentBusWithBookings.setBookings(newBooking);
		
		busRepository.save(currentBusWithBookings); 
		
		
		return seatNumbers; 
	}
	
	
	
	
}
