package com.projects.controllers;

import org.springframework.stereotype.Component;

@Component
public class UserBean {
	
	public UserBean() {
		super();
	}
	public UserBean(String email, String firstname, String mobileNo) {
		super();
		this.email = email;
		this.firstname = firstname;
		this.mobileNo = mobileNo;
	}
	private String email;
	private String firstname;
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
	
	

	
}
