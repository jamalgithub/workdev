package com.in28minutes.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.model.Todo;
import com.in28minutes.service.TodoService;

@RestController
@RequestMapping("/rest")
public class TodoRestController {
	
	@Autowired
	private TodoService service;

	@RequestMapping(value = "/todo", method = RequestMethod.GET)
	public List<Todo> listAllTodos() {
		List<Todo> users = service.retrieveTodos("in28Minutes");
		return users;
	}

	@RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
	public Todo retrieveTodo(@PathVariable("id") int id) {
		return service.retrieveTodo(id);
	}
	
	/*@RequestMapping(value="/todo", method=RequestMethod.POST)
	public void addTodo(@RequestBody Todo todo) {
		service.addTodo(todo.getUser(), todo.getDesc(), todo.getTargetDate(), todo.isDone());
	}
	
	@RequestMapping(value="/todo", method=RequestMethod.PUT)
	public void updateTodo(@RequestBody Todo todo) {		
		service.updateTodo(todo);
	}
	
	@RequestMapping(value="/todo/{id}", method=RequestMethod.DELETE)
	public void deleteTodo(@PathVariable("id") int id) {
		service.deleteTodo(id);
	}*/
}