package com.shantanu.SpringPractice2.webMvc.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class loginController {
	
	@RequestMapping("/dologin")
	public String login(@RequestParam String name, @RequestParam String age, ModelMap modelForView) {
		System.out.println(name);
		System.out.println(age);
		modelForView.put("param1",name);
		modelForView.put("param2",age);
		return "login";
	}

}
