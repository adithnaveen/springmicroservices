package com.social.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.login.authenticate.dao.UserRepository;
import com.login.authenticate.entities.Name;
import com.login.authenticate.entities.Payment;
import com.login.authenticate.entities.User;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class UserRepositoryTest {

	
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository userRepository1; 
	/*
	@Test
	public void testSave() {
		UserSocial user = new UserSocial();
		user.setUsername("user.user");
		user.setFullName("kamalbberriga");
		entityManager.persist(user);
		entityManager.flush();
		// when
		UserSocial testUser = userRepository.findOne(user.getId());
		// then
		assertThat(testUser.getFullName()).isEqualTo(user.getFullName());
	}*/

	@Test
	public void testSaveMongoDB(){
		User user = new User("naveen@probits.in", "naveen", true, "MALE", 
			new Name("Naveen", "Srinivas"), 
			new Payment("12121212", "01/10")); 
		
		entityManager.persist(user); 
		entityManager.flush(); 
		
		User testUser = userRepository1.findByEmail(user.getEmail()); 
		
		assertThat(testUser.getName().getFirstName()).isEqualTo(user.getName().getFirstName()); 
		
		
		
		
		
		
	}
	
	/*
	

	// test method for the findOneByUsername
    @Test
    public void findOneByUsername() {
    	UserSocial user = new UserSocial();
		user.setUsername("user.user");
		user.setFullName("kamalberriga");
        entityManager.persist(user);

        UserSocial testUser = userRepository.findOneByUsername(user.getUsername());
		// then
		assertThat(testUser.getUsername()).isEqualTo(user.getUsername());
    }
	
*/
	

	// test method for the findOneByEmail
    @Test
    public void findOneByEmail() {
    	User user = new User("naveen@probits.in", "naveen", true, "MALE", 
    			new Name("Naveen", "Srinivas"), 
    			new Payment("12121212", "01/10")); 
    		
    	User testUser = userRepository1.findByEmail(user.getEmail()); 
		
    	assertThat(testUser.getUsername()).isEqualTo(user.getUsername());
    }
}
