package com.projects.model;

public class Payment {
	private String cardNumber; 
	private String cardExpMonthYear;
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardExpMonthYear() {
		return cardExpMonthYear;
	}
	public void setCardExpMonthYear(String cardExpMonthYear) {
		this.cardExpMonthYear = cardExpMonthYear;
	}
	
	public Payment(){}
	public Payment(String cardNumber, String cardExpMonthYear) {
		super();
		this.cardNumber = cardNumber;
		this.cardExpMonthYear = cardExpMonthYear;
	} 
	
	
}
