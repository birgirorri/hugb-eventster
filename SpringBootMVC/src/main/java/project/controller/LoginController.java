package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.service.StringManipulationService;
import project.service.UserService;
import project.persistence.entities.*;

@Controller
public class LoginController{
	
	
	StringManipulationService stringService;
	UserService userService;
	

	// Dependency Injection
	@Autowired
	public LoginController(StringManipulationService stringService) {
		this.stringService = stringService;
	}
	
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)   
	public void createNewUser(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email,Model model){
		User newUser = new User(username,password, email);
	    userService.createUser(newUser);
	}
	   
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String validLogin(@RequestParam("email") String email, @RequestParam("password") String password,Model model){
		   
		System.out.println(email + "  " + password + "------------------------------------------");
		System.out.println("outcome:----------------------------------------");
		System.out.print(userService.validateLogin(email, password) + " ");
		System.out.println("debug---------------------------------------------");
		if(userService.validateLogin(email, password)) {
			return "Events";
		} else {
			return "Index";
		}
	}
}