package com.projects.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.projects.ServiceBean1;
import com.projects.config.LoginConfiguration;
import com.projects.proxy.ServiceProxy;
@RefreshScope
@RestController
public class LoginController {

	@Autowired
	private ServiceProxy proxy;
	
	@Autowired
	private LoginConfiguration serviceConfig;
	
	@HystrixCommand(fallbackMethod="fallbackmethod")
	@GetMapping("/hello/email/{email}")
	public ServiceBean1 sayHelloService(@PathVariable("email") String email)
	{
			
		//String url="http://localhost:8085/getuser/email/{email}";
		ServiceBean1 responseBean=proxy.retrieveUser(email);
		System.out.println(responseBean);
		if(responseBean==null) throw new RuntimeException();
		
		responseBean.setConfiguration(serviceConfig);
		System.out.println(responseBean.getEmail());
		return responseBean;
	}
	
	public ServiceBean1 fallbackmethod(@PathVariable("email") String email)
	{
		ServiceBean1 bean1= new ServiceBean1("XXXX.gmail.com", "user", "00000")	;
		bean1.setConfiguration(serviceConfig);
	    return bean1;
	}
	
	
}
