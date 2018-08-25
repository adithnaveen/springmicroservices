package com.projects.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.projects.model.Booking;
import com.projects.model.Bus;


/**
 * 
 * @author Naveen Srinivas
 * @see This class shall hae the methods only starting with findBy<attribute
 *      name> where it starts with upper case for example variable name:
 *      busTitle method name should be : findByBusTitle
 * 
 */
public interface BusRepository extends MongoRepository<Bus, String> {
	
	public Bus findByBusTitle(String busTitle);

	public List<Bus> findByBusSource(String src);

	public List<Bus> findByBusDestination(String destination);

	// this method is used for the user when he/she wants to see 
	// their bookings 
	public List<Booking> findByBookings(Booking booking);
	

	/**
	 * 
	 * @author Naveen Srinivas
	 * @param email
	 * @return List<Bus>
	 * @see This method is used to know how many bookings the user has done 
	 *      / booking history 
	 */
	@Query(value="{'bookings.bookingEmail':?0}", 
			fields="{'busTitle':1, 'totalNoOfSeats':1, 'busType':1, "
					+ "'busTravelDate':1,'busTravelTime':1, 'busSource':1, 'busDestination':1, "
					+ "'bookings.noOfSeats':1, 'bookings.totalCost':1}")
	public List<Bus> findByBussesForEmail(String email); 
	
	

	// get busses based on source, destination and date  when user enters for searching 
	// this method returns busname, no_of_seats available, total_number_of_seats 
	// time, cost per seat 
	
	/**
	 * @author Naveen Srinivas
	 * @param source
	 * @param destination
	 * @param busTravelDate
	 * @return List<Bus>
	 * @see This method is used for getting the bus information when user enters 
	 *      Source, Destination and date for the booking 
	 */
	@Query(
			value="{'busSource':?0, 'busDestination':?1, 'busTravelDate':?2}", 
			fields="{'busTitle':1, 'totalNoOfSeats':1, 'noOfSeatsAvailable':1, "
					+ "'busType':1, 'busTravelDate':1, 'busTravelTime':1,"
					+ " 'busSource':1, 'busDestination':1, 'costPerSeat':1}")
													   
	
	public List<Bus> findBySourceDestinationDate(String source, String destination, String busTravelDate);
	
	
	
	
	
}



















