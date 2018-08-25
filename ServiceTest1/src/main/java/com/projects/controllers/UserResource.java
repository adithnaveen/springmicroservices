package com.projects.controllers;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.projects.ServiceBean1;
import com.projects.model.Name;
import com.projects.model.Payment;
import com.projects.model.User;
import com.projects.proxy.ServiceProxy;
import com.projects.service.UserSerivce;

@CrossOrigin(origins={"http://localhost:4200", 
		"http://localhost:8081"}, maxAge=3600)
@RestController
@RequestMapping("/rest")
public class UserResource {
	@Autowired
	private UserSerivce userService;

	// we can user for user registration 
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return userService.create(user);
	}

	@GetMapping("/user")
	public List<User> getAll() {
		return userService.getAllUsers();
	}
	
	@PutMapping("/user")
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

	
	
	
	
	

	@Autowired
	private ServiceProxy proxy;
	
	
	@HystrixCommand(fallbackMethod="fallbackmethod")
	@GetMapping("/user/{email}")
	public User getUserByEmail(@PathVariable
			String email){
		User responseUser = proxy.retrieveUser1(email); 
		
		if(responseUser == null) throw new RuntimeException("User Not Found for " + email); 
		
		System.out.println("User Retrived is " + responseUser);
		
		return responseUser; 
	}
	
	
	
	public User fallbackmethod(@PathVariable("email") String email)
	{
		User user = new User("*****email****", "****password****", false, "****GENDER***", new Name("****FirstName****", "*****LasteName****"), 
				new Payment("0000000000", "00/00"));  
	    return user;
	}
	


}
