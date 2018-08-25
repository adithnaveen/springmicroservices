package com.projects.model;

/**
 * 
 * @author Naveen
 * This class is used for booking ticket, since there were number of params
 */
public class TicketBooking {
	private String busTitle; 
	private int numberOfSeats; 
	private String email; 
	private String paymentMode; 
	private String creditCardNumber; 
	private int expiryYear; 
	private int expiryMonth;
	
	
	public TicketBooking(){}
	
	public TicketBooking(String busTitle, int numberOfSeats, String email, String paymentMode, String creditCardNumber,
			int expiryYear, int expiryMonth) {
		super();
		this.busTitle = busTitle;
		this.numberOfSeats = numberOfSeats;
		this.email = email;
		this.paymentMode = paymentMode;
		this.creditCardNumber = creditCardNumber;
		this.expiryYear = expiryYear;
		this.expiryMonth = expiryMonth;
	}

	public String getBusTitle() {
		return busTitle;
	}

	public void setBusTitle(String busTitle) {
		this.busTitle = busTitle;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
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
	
	
	
	
}
