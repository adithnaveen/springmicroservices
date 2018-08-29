package com.login.authenticate.entities;


import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 
 * @author Naveen Srinivas
 * @since 2018 
 * @see this class will be data model which shall be used for 
 *      Registration and Login(email & Password) 
 */

@Document(collection="user")
@Scope("session")
public class User implements UserDetails{
	public static enum Role{ USER }

	private String id;
	// dropDups=true we need not have uniq in mongod 
	@Indexed(unique=true, direction=IndexDirection.DESCENDING, dropDups=true)

	private String email; 
	private String password; 
	private boolean enabled;
	// MALE/FEMALE
	private String gender; 
	private Name name; 
	private Payment payment; 
	private String role; 
	
	public User(){}
	
	public User(String email, String password, boolean enabled, String gender, 
			Name name, Payment payment) {
		super();
		this.name = name; 
		this.gender = gender; 
		this.payment = payment; 
		this.email = email;
		this.password = password;
		this.enabled = enabled;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(getRole()));
		return authorities;
	}

	@Override
	public String getUsername() {

		return this.getName().getFirstName() + ", " + 
				this.getName().getLastName(); 
				
			
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
