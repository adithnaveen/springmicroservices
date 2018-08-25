package com.projects.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;


/**
 * 
 * @author Naveen
 *  this class shall have the mongorepo for the method which takes email as input and gives 
 *  user object as return value 
 */


@Repository
public class UserRepo {

	private Map<String,UserBean> userList=new HashMap<>();
	
	public UserRepo()
	{
		userList.put("abc", new UserBean("abc", "sam", "877"));
		userList.put("xyz", new UserBean("xyz", "peter", "987"));
		userList.put("pqr", new UserBean("pqr", "john", "975"));
	}
	
	public UserBean getUser(String email)
	{
		return userList.get(email);
	}
}
