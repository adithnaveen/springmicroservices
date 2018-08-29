package com.login.authenticate.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.login.authenticate.entities.User;

/**
 * 
 * @author Naveen Srinivas 
 * @see This interface shall register all the custom methods required, 
 *      there are CRUD methods which are already defined in MongoRepository
 *      those can be excluded rest can be entered here, the methods can also 
 *      take an annotation @Query where we can pass custom query 
 */
public interface UserRepository extends MongoRepository<User, String>{
	// here we can write any number of methods 

	// for getting the user given email 
	public User findByEmail(String emial);
	
	// for validating the user given email(username) and password 
	@Query("{ 'email' :?0, 'password':?1}")
	public User findByEmailAndPassword(String email, String password); 
}

