package com.projects.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="bus")
public class Bus {

//	@Indexed(unique=true, direction=IndexDirection.DESCENDING, dropDups=true)
	@Id
	private String busTitle; 
	private int totalNoOfSeats;
	private int noOfSeatsAvailable; 
	private String busType; 
	// format used is yyyy-mm-dd ex: 2018-10-20 (Date class is not used temporarily) 
	private String busTravelDate; 
	// format used is hh:mm ex 21:44 (Time is treated as string temporarily) 
	private String busTravelTime ; 
	
	private String busSource; 
	private String busDestination; 
	
	private double costPerSeat; 
	
	private List<Booking> bookings;
	
	@PersistenceConstructor
	public Bus(){}
	
	
	public Bus(
				String busTitle, int totalNoOfSeats, int noOfSeatsAvailable, 
				String busType, String busTravelDate,  String busTravelTime,  
				String busSource, String busDestination, double costPerSeat, List<Booking> bookings) {
		this.busTitle = busTitle;
		this.totalNoOfSeats = totalNoOfSeats;
		this.noOfSeatsAvailable = noOfSeatsAvailable; 
		this.busType = busType;
		this.busTravelDate = busTravelDate;
		this.busTravelTime = busTravelTime; 
		this.busSource = busSource;
		this.busDestination = busDestination;
		this.costPerSeat = costPerSeat; 
		this.bookings = bookings;
	}

	
	
	public String getBusTravelDate() {
		return busTravelDate;
	}
	public void setBusTravelDate(String busTravelDate) {
		this.busTravelDate = busTravelDate;
	}
	public String getBusTravelTime() {
		return busTravelTime;
	}
	public void setBusTravelTime(String busTravelTime) {
		this.busTravelTime = busTravelTime;
	}
	public String getBusTitle() {
		return busTitle;
	}

	public void setBusTitle(String busTitle) {
		this.busTitle = busTitle;
	}

	public int getTotalNoOfSeats() {
		return totalNoOfSeats;
	}

	public void setTotalNoOfSeats(int totalNoOfSeats) {
		this.totalNoOfSeats = totalNoOfSeats;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getBusSource() {
		return busSource;
	}

	public void setBusSource(String busSource) {
		this.busSource = busSource;
	}

	public String getBusDestination() {
		return busDestination;
	}

	public void setBusDestination(String busDestination) {
		this.busDestination = busDestination;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	public int getNoOfSeatsAvailable() {
		return noOfSeatsAvailable;
	}
	public void setNoOfSeatsAvailable(int noOfSeatsAvailable) {
		this.noOfSeatsAvailable = noOfSeatsAvailable;
	}
	public double getCostPerSeat() {
		return costPerSeat;
	}
	public void setCostPerSeat(double costPerSeat) {
		this.costPerSeat = costPerSeat;
	}


	@Override
	public String toString() {
		return "Bus [busTitle=" + busTitle + ", totalNoOfSeats=" + totalNoOfSeats + ", noOfSeatsAvailable="
				+ noOfSeatsAvailable + ", busType=" + busType + ", busTravelDate=" + busTravelDate + ", busTravelTime="
				+ busTravelTime + ", busSource=" + busSource + ", busDestination=" + busDestination + ", costPerSeat="
				+ costPerSeat + ", bookings=" + bookings + "]";
	} 

	
}
