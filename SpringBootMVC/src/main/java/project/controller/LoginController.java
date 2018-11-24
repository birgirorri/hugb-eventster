package project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.service.*;
import project.persistence.entities.*;

@Controller
public class LoginController {

	// StringManipulationService stringService;
	UserService userService;

	// Dependency Injection
	@Autowired
	public LoginController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String createNewUser(Model model, @RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("email") String email) {
		User newUser = new User(username, password, email);
		System.out.println("emailið er: " + newUser.getEmail());
		userService.createUser(newUser);
		
		return "Index";
	}

	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String validLogin(@RequestParam("email") String email, @RequestParam("password") String password,
			Model model) {

		User login_user = userService.findByEmail(email);
		
		if(login_user != null) {
			if (login_user.getPassword().equals(password)) {
				
				userService.setCurrentUser(login_user);
				
				return "Events";
			} else {
				return "Index";
			}
		} else {
			return "Index";
		}
	}
	
	@RequestMapping(value = "/LoadUser", method = RequestMethod.GET)
	public String preloadUser(Model model) {
		User birgir = new User("birgir","birgir","birgir@hi.is");
		User adam = new User("adam","adam","adam@hi.is");
		User marino = new User("marino","marino","marino@hi.is");
		userService.createUser(birgir);
		userService.createUser(adam);
		userService.createUser(marino);
		
		return "Index";
	}
	
	@RequestMapping(value = "/GuestUser", method = RequestMethod.GET)
	public String GuestSignIn(Model model) {
		User Guest = new User("guest","guest","guest@email.is");
		userService.createUser(Guest);
		userService.setCurrentUser(Guest);
		
		return "Index";
	}
}