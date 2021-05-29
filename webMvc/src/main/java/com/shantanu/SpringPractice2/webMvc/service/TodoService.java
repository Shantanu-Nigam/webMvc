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
	
	public ArrayList<Todo> showAllTodos(String myModel) {
		ArrayList<Todo> filteredTodosByUser = new ArrayList<Todo>();
		System.out.println(myModel);
		for(Todo t : myTodos) {
			System.out.println(t.toString());
			if(t.getOwner().equalsIgnoreCase(myModel)) {
				filteredTodosByUser.add(t);
			}
		}
		 
		 return filteredTodosByUser; 
	}
	
	public void createTodo(String owner, String description, String isComplete) {
		myTodos.add(new Todo(++todosCount, owner, description, new Date(), Boolean.parseBoolean(isComplete)));
		
	}
	
	public Todo getTodoWithId(String id, String name) {
		Todo gotTodo = null;
		for(Todo item : myTodos) {
			if(Integer.parseInt(id) == item.getId()) {
				gotTodo = item;
			}
		}
		return gotTodo;
	}
	
	public void updateTodoWithId(String id, String name, String descToUpdate, String statusToUpdate) {
		Todo toUpdate = getTodoWithId(id, name);
		int index = findIndex(toUpdate.getId());
		myTodos.remove(index);
		toUpdate.setDesc(descToUpdate);
		toUpdate.setComplete(Boolean.parseBoolean(statusToUpdate));
		myTodos.add(index, toUpdate);
	}

	public void deleteTodoWithId(String id, String name) {
		Todo toUpdate = getTodoWithId(id, name);
		int index = findIndex(toUpdate.getId());
		//console.log("index = "+index);
		System.out.println("index = "+index);
		myTodos.remove(index);
		
	}
	
	public int findIndex(int id) {
		int index = 0;
		for(Todo t : myTodos) {
			if(t.getId() == id) {
				return index;
			}
			index++;
		}
		return index;
	}


	
}
