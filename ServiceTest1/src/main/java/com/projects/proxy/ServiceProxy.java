package com.projects.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.projects.ServiceBean1;
import com.projects.model.User;

@FeignClient(name = "businessservice", url = "localhost:8085")
// @FeignClient(name="currencyexchange")
// @RibbonClient(name="currencyexchange")
public interface ServiceProxy {

	@GetMapping("/getuser/email/{email}")
	public ServiceBean1 retrieveUser(@PathVariable("email") String email);

	
	
	// this method is used in userresource 
	@GetMapping("/rest/user/{email}")
	public User retrieveUser1(@PathVariable("email") String email);

}
