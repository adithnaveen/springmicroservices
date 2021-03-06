package com.projects.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projects.config.BookingConfiguration;

@Component
public class ServiceBean1 {
	
	@Autowired
	private BookingConfiguration configuration;
	
	public ServiceBean1() {
		super();
	}
	public ServiceBean1(String email, String firstname, String mobileNo) {
		super();
		//this.conf = conf;
		this.email = email;
		this.firstname = firstname;
		this.mobileNo = mobileNo;
	}
	private String email;
	private String firstname;
	public BookingConfiguration getConfiguration() {
		return configuration;
	}
	public void setConfiguration(BookingConfiguration configuration) {
		this.configuration = configuration;
	}
	private String mobileNo;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "ServiceBean1 [email=" + email + ", firstname=" + firstname + ", mobileNo=" + mobileNo + "]";
	}

	
	
	
}
