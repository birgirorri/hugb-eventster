package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.service.StringManipulationService;
import project.service.UserService;
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
	public void createNewUser(Model model, @RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("email") String email) {
		User newUser = new User(username, password, email);
		System.out.println("emailið er: " + newUser.getEmail());
		userService.createUser(newUser);
	}

	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String validLogin(@RequestParam("email") String email, @RequestParam("password") String password,
			Model model) {

		System.out.println("fer inní login fallið");

		User login_user = userService.validLogin(email);
		

		
		if (login_user.getPassword().equals(password)) {
			return "Events";
		}
		else {
			System.out.println("farðu heim ");
			return "Index";
		}
		
	}
}