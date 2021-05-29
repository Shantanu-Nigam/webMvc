package com.shantanu.SpringPractice2.webMvc.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		ArrayList<Todo> todosForUser = service.showAllTodos((String)mymodel.get("name"));
		mymodel.put("Todos", todosForUser);
		return "list";
		
	}
	
	@RequestMapping(value = "/todo-list",method = RequestMethod.POST)
	public String updateTodoListForUser(@RequestParam String idToUpdate, ModelMap mymodel) {
		Todo todoToUpdate = service.getTodoWithId(idToUpdate, (String)mymodel.get("name"));
		System.out.println("todo to update is: "+todoToUpdate);
		mymodel.put("UpdateTodo", todoToUpdate);
		return "updateTodo";
		
	}
	
	@RequestMapping(value = "/add-todo",method = RequestMethod.GET)
	public String showAddTodoPage() {
		return "addTodo";
	}
	
	@RequestMapping(value = "/add-todo",method = RequestMethod.POST)
	public String AddTodo(ModelMap myMap,@RequestParam String description, @RequestParam String completeStatus) {
		service.createTodo((String)myMap.get("name"), description, completeStatus);
		return "redirect:/todo-list";
	}
	
	@RequestMapping(value = "/updated-list",method = RequestMethod.POST)
	public String showUpdatedTodoListForUser(@RequestParam String todoID,@RequestParam String NewDesc, @RequestParam String NewStatus, @RequestParam String deleteIt, ModelMap mymodel) {
		if(deleteIt.equalsIgnoreCase("Yes")) {
			service.deleteTodoWithId(todoID, (String)mymodel.get("name"));
		}else {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			service.updateTodoWithId(todoID, (String)mymodel.get("name"), NewDesc, NewStatus);
		}
		
		
		return "redirect:/todo-list";
		
	}

}
