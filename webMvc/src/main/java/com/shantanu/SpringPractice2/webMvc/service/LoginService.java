package com.shantanu.SpringPractice2.webMvc.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
	
	public boolean isUserValid(String name, String password) {
		
		return true && password.equalsIgnoreCase("Devilreaper");
		
	}

}
