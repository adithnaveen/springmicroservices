package com.projects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker
//@EnableDiscoveryClient
@EnableFeignClients("com.projects")
@SpringBootApplication
public class LoginTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginTestApplication.class, args);
	}
}
