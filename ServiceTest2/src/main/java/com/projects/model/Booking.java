package com.projects.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// this class shall not have any 
//@Document(collection = "bookings")
public class Booking {
//	
//	@Id
//	private int bookingId;
	private String bookingEmail;
	private int noOfSeats;
	private double totalCost;
	private String paymentMethod;
	private String creditCardNumber;
	private int expiryYear;
	private int expiryMonth;
	private List<Integer> ticketNumbers;

	public Booking() {
	}

	public Booking(String bookingEmail, int noOfSeats, double totalCost, String paymentMethod, String creditCardNumber,
			int expiryYear, int expiryMonth, List<Integer> ticketNumbers) {
		super();
		this.bookingEmail = bookingEmail;
		this.noOfSeats = noOfSeats;
		this.totalCost = totalCost;
		this.paymentMethod = paymentMethod;
		this.creditCardNumber = creditCardNumber;
		this.expiryYear = expiryYear;
		this.expiryMonth = expiryMonth;
		this.ticketNumbers = ticketNumbers;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public int getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(int expiryYear) {
		this.expiryYear = expiryYear;
	}

	public int getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(int expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public List<Integer> getTicketNumbers() {
		return ticketNumbers;
	}

	public void setTicketNumbers(List<Integer> ticketNumbers) {
		this.ticketNumbers = ticketNumbers;
	}

	public String getBookingEmail() {
		return bookingEmail;
	}

	public void setBookingEmail(String bookingEmail) {
		this.bookingEmail = bookingEmail;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Override
	public String toString() {
		return "Booking [bookingEmail=" + bookingEmail + ", noOfSeats=" + noOfSeats + ", totalCost=" + totalCost
				+ ", paymentMethod=" + paymentMethod + ", creditCardNumber=" + creditCardNumber + ", expiryYear="
				+ expiryYear + ", expiryMonth=" + expiryMonth + ", ticketNumbers=" + ticketNumbers + "]";
	}
	
	
}
