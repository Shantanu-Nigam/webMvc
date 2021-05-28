package com.shantanu.SpringPractice2.webMvc.service;

import java.util.ArrayList;
import java.util.Date;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.shantanu.SpringPractice2.webMvc.modals.Todo;

@Component
public class TodoService {
	
	private static ArrayList<Todo> myTodos = new ArrayList<Todo>();
	
	private static int todosCount = 3;
	
	static {
		myTodos.add(new Todo(1,"Shantanu","Learn JavaScript", new Date(), false));
		myTodos.add(new Todo(2,"Shantanu","Learn Spring Framework", new Date(), false));
		myTodos.add(new Todo(3,"Shantanu","Learn MicroServices", new Date(), false));
	}
	
	public String showAllTodos(String myModel) {
		ArrayList<Todo> filteredTodosByUser = new ArrayList<Todo>();
		System.out.println(myModel);
		for(Todo t : myTodos) {
			System.out.println(t.toString());
			if(t.getOwner().equalsIgnoreCase(myModel)) {
				filteredTodosByUser.add(t);
			}
		}
		
		 if(!filteredTodosByUser.isEmpty()) {
			return filteredTodosByUser.toString(); 
		 }
		 
		 return "Your Slate is Clean";
	}

	
}
