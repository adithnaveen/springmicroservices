package com.projects.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.projects.model.Name;
import com.projects.model.Payment;
import com.projects.model.User;
import com.projects.repository.UserRepository;

@Configuration
@EnableMongoRepositories(basePackageClasses=UserRepository.class)
public class MongoDBConfig {

	
	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository){
		return string -> {
			userRepository.save(new User("naveen@probits.in", "testing", true, "MALE", new Name("Naveen", "Kumar"), new Payment("332211112233", "01/20")));
			userRepository.save(new User("kumar@probits.in", "hello", true, "MALE", new Name("Kumar", "Kanteerava"), new Payment("1234512345", "05/22")));
			
		}; 
	}
}


