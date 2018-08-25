package com.projects.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessController {

	@Autowired
	private UserRepo repo;

	// http://localhost:8085/getuser/email/abc
	@GetMapping("/getuser/email/{email}")
	public UserBean getUser(@PathVariable("email") String email) {
		return repo.getUser(email);
	}
}
