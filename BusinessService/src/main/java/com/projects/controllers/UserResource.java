package com.projects.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.model.User;
import com.projects.service.UserSerivce;

@CrossOrigin(origins={"http://localhost:4200", "http://localhost:8085"}, maxAge=3600)
@RestController
@RequestMapping("/rest")
public class UserResource {
	@Autowired
	private UserSerivce userService;

	@GetMapping("/user/{email}")
	public User getUserByEmail(@PathVariable
			String email){
//		System.out.println("Called to get user email");
//		 System.out.println(userService.getByEmail(email));
		return userService.getByEmail(email);
	
	}
}

