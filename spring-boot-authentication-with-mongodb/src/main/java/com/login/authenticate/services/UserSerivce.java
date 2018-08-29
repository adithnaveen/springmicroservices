package com.login.authenticate.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.authenticate.dao.UserRepository;
import com.login.authenticate.entities.User;

@Service
public class UserSerivce {

	@Autowired
	private UserRepository userRepository; 
	
	
	public User create(User user){
		return userRepository.save(user); 
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll(); 
	}
	
	// this is the only method we where have entered in UserRepository 
	public User getByEmail(String email){
		return userRepository.findByEmail(email); 
	}
	
	public User update(User user){
		User tempUser = userRepository.findByEmail(user.getEmail()); 
		tempUser.setPassword(user.getPassword());
		tempUser.setName(user.getName());

		return userRepository.save(tempUser); 
	}
	
	public void deleteAll(){
		userRepository.deleteAll();
	}
	
	
	public boolean delete(String email){
		User user = userRepository.findByEmail(email);
		if(user !=null){
			userRepository.delete(user);
			return true; 
		}else{
			return false; 
		}
	}
	
	// to validate given user 
	public boolean loginValidate(String email, String password){
		return  userRepository.findByEmailAndPassword(email, password)!=null ? true:false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
