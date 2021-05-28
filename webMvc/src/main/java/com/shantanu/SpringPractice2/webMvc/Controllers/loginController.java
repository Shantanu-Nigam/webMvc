package com.shantanu.SpringPractice2.webMvc.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.shantanu.SpringPractice2.webMvc.service.LoginService;

@Controller
@SessionAttributes("name")
public class loginController {
	@Autowired
	LoginService service;
	
	@RequestMapping(value = "/dologin",method = RequestMethod.GET)
	public String login() {
//		System.out.println(name);
//		System.out.println(age);
//		modelForView.put("param1",name);
//		modelForView.put("param2",age);
		
		
		return "login";
	}
	
	@RequestMapping(value = "/dologin",method = RequestMethod.POST)
	public String loginForm(@RequestParam String YourName, @RequestParam String YourPassword, ModelMap modelForView) {
//		System.out.println(name);
//		System.out.println(age);
//		modelForView.put("param1",name);
//		modelForView.put("param2",age);
		
		
		
		if(!service.isUserValid(YourName, YourPassword)) {
			modelForView.put("errorMessage", "Invalid Credentials...Please try again");
			return "login";
		}
		
		modelForView.put("name", YourName);
		
		
		return "welcome";
	}

}
