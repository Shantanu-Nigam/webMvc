package com.shantanu.SpringPractice2.webMvc.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.shantanu.SpringPractice2.webMvc.modals.Todo;
import com.shantanu.SpringPractice2.webMvc.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoControler {
	
	@Autowired
	TodoService service;
	
	@RequestMapping(value = "/todo-list",method = RequestMethod.GET)
	public String showTodoListForUser(ModelMap mymodel) {
		System.out.println((String)mymodel.get("name"));
		String todosForUser = service.showAllTodos((String)mymodel.get("name"));
		mymodel.put("Todos", todosForUser);
		return "list";
		
	}

}
