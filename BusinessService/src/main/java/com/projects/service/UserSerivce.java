package com.projects.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.model.User;
import com.projects.repository.UserRepository;


@Service
public class UserSerivce {

	@Autowired
	private UserRepository userRepository; 
	


	// this is the only method we where have entered in UserRepository 
	public User getByEmail(String email){
		return userRepository.findByEmail(email); 
	}
	
}
