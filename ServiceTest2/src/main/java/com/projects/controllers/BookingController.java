package com.projects.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.projects.config.BookingConfiguration;
import com.projects.model.ServiceBean1;
import com.projects.proxy.ServiceProxy;


@RefreshScope
@RestController
public class BookingController {


	@Autowired
	private ServiceProxy proxy;
	

	
	@Autowired
	BookingConfiguration service2Config;
	
	@GetMapping("/config")
	public BookingConfiguration sayHiService()
	{
		/*Map<String,String> map=new HashMap<>();
		map.put("param1", serviceConfig.getParam1());
		map.put("param2",serviceConfig.getParam2());*/
		
		return service2Config;
	}
	
	

	@HystrixCommand(fallbackMethod="fallbackmethod")
	@GetMapping("/hello1/email/{email}")
	public ServiceBean1 sayHelloService(@PathVariable("email") String email)
	{
			
		//String url="http://localhost:8085/getuser/email/{email}";
		ServiceBean1 responseBean=proxy.retrieveUser(email);
		System.out.println(responseBean);
		if(responseBean==null) throw new RuntimeException();
		
		responseBean.setConfiguration(service2Config);
		System.out.println(responseBean.getEmail());
		return responseBean;
	}
	

	public ServiceBean1 fallbackmethod(@PathVariable("email") String email)
	{
		ServiceBean1 bean1= new ServiceBean1("XXXX.gmail.com", "user", "00000")	;
		bean1.setConfiguration(service2Config);
	    return bean1;
	}
	
	
}
