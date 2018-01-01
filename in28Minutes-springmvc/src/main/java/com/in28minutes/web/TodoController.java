package com.in28minutes.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.model.Todo;
import com.in28minutes.service.TodoService;

@Controller
@SessionAttributes("name")
@RequestMapping("/todo")
public class TodoController {
	//private Logger logger = Logger.getLogger(ExceptionController.class);
	
	@Autowired
	private TodoService service;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showTodosList(ModelMap model) {
		//String user = (String) model.get("name");
		String user = getLoggedInUserName();
		model.addAttribute("todos", service.retrieveTodos(user));
		return "list-todos";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showTodoPage(ModelMap model) {
		//throw new RuntimeException("Dummy Exception");
		model.addAttribute("todo", new Todo());
		return "todo";
	}

	//@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @RequestParam String desc) {
		service.addTodo((String) model.get("name"), desc, new Date(), false);
		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:/list-todos";
	}
	
	//@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo_(ModelMap model, @Valid @ModelAttribute("todo") Todo todo, BindingResult result) {
		if (result.hasErrors())
			return "todo";

		service.addTodo(getLoggedInUserName(), todo.getDesc(), new Date(), false);
		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:/list-todos";
	}
	
	//@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(@ModelAttribute("name") String name, HttpSession session, ModelMap model, @Valid @ModelAttribute("todo") Todo todo, BindingResult result) {
		if (result.hasErrors())
			return "todo";

		//String name = (String) session.getAttribute("name"); <=====> @ModelAttribute("name") String name
		service.addTodo(name, todo.getDesc(), new Date(), false);
		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid @ModelAttribute("todo") Todo todo, BindingResult result) {
		if (result.hasErrors())
			return "todo";

		service.addTodo(getLoggedInUserName(), todo.getDesc(), new Date(), false);
		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(ModelMap model, @RequestParam int id) {
		model.addAttribute("todo", service.retrieveTodo(id));
		return "todo";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid @ModelAttribute("todo") Todo todo, BindingResult result) {
		if (result.hasErrors())
			return "todo";

		todo.setUser(getLoggedInUserName());
		service.updateTodo(todo);

		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		service.deleteTodo(id);

		return "redirect:/list-todos";
	}
	
	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}
	
	/*@ExceptionHandler(value = Exception.class)
	public String handleException(HttpServletRequest request, Exception ex) {
		logger.error("Request " + request.getRequestURL() + " Threw an Exception", ex);
		
		return "error-specific";
	}*/
}