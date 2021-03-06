package com.projects;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class SecurityDemoOAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityDemoOAuthApplication.class, args);
	}
	
	 @GetMapping("/userInfo")
	    public Map<String, Object> user(OAuth2Authentication user) {
	        Map<String, Object> userInfo = new HashMap<>();
	        userInfo.put("user", user.getUserAuthentication().getPrincipal());
	        userInfo.put("authorities", AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));
	        return userInfo;
	    }
}
