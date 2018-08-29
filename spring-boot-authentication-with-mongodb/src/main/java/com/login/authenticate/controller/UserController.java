package com.login.authenticate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.authenticate.entities.User;
import com.login.authenticate.services.UserSerivce;


@CrossOrigin(origins={"http://localhost:4200", "http://localhost:8098"}, maxAge=3600)
@RestController
@RequestMapping("/rest")
public class UserController {
	@Autowired
	private UserSerivce userService;

	// we can user for user registration 
	@PostMapping("/user/register")
	public User createUser(@RequestBody User user) {
		return userService.create(user);
	}

	
	
	@GetMapping("/user")
	public List<User> getAll() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/{email}")
	public User getUserByEmail(@PathVariable
			String email){
		System.out.println("invoked with email " + email);
		return userService.getByEmail(email); 
	}
	
	@PutMapping("/user/update")
	public User updateUser(@RequestBody User user){
		return userService.update(user); 
	}
	
	@DeleteMapping("/user/{email}")
	public boolean delete(@PathVariable String email){
		return userService.delete(email); 
	}
	
	@GetMapping("/user/email/{email}/password/{password}")
	public boolean loginValidate(@PathVariable String email, 
				@PathVariable String password){
		return userService.loginValidate(email, password); 
	}
	
	
}
