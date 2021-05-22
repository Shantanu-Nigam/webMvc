package com.shantanu.SpringPractice2.webMvc.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class loginController {
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

}
