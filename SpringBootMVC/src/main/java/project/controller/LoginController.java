package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.service.StringManipulationService;
import project.service.UserService;
import project.persistence.entities.*;

@Controller
public class LoginController{
	
	
	 StringManipulationService stringService;
	

	    // Dependency Injection
	    @Autowired
	    public LoginController(StringManipulationService stringService) {
	        this.stringService = stringService;
	    }
	
	    
	    public void createNewUser(String username, String password, String email){
	    	
	    
	    }
	   
	   // @RequestMapping(value = "/user", method = RequestMethod.GET)
	    public String validLogin(String username, String password, Model model){
	    	
	    	
	    	return "User";
	    }
	    
	    
	    
	    public String loginViewGet(Model model) {
	    	return "hello";
	    }
	    
}