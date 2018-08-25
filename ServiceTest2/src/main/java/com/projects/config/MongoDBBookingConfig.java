package com.projects.config;

import java.util.Arrays;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.projects.model.Booking;
import com.projects.model.Bus;
import com.projects.repository.BusRepository;


@Configuration
@EnableMongoRepositories
	(basePackageClasses=
		{BusRepository.class}
	)
public class MongoDBBookingConfig {
	@Bean
	CommandLineRunner commandLineRunner(BusRepository busRepository){
		return string -> {
			System.out.println("in CommandLineRunner for Inserting User records in MongoDB");
			
			Booking booking1 = new Booking("naveen@gmail.com", 2, 333, "CREDIT", "232323", 2020, 1, Arrays.asList(1,2)); 
			Booking booking2 = new Booking("nav@gmail.com", 2, 555, "DEBIT", "232323", 2009, 7, Arrays.asList(3,4)); 
			Booking booking3 = new Booking("radha@gmail.com", 3, 444, "CREDIT", "232323", 2010, 10, Arrays.asList(5,6,7)); 
			busRepository.save(new Bus("B1", 50, 50, "MultiAxle", "2018-02-21", "21:00", "BLR", "DVG", 111.0,  Arrays.asList(booking1, booking2))); 
			busRepository.save(new Bus("B2", 40, 40, "Rear Enginee", "2019-02-22", "17:00", "BLR", "TMK",200.0,  Arrays.asList(booking3))); 
		} ; 	
	}
}
