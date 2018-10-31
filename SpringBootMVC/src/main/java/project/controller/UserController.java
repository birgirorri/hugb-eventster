package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.service.StringManipulationService;

@Controller
public class UserController {

    // Instance Variables
    StringManipulationService stringService;

    // Dependency Injection
    @Autowired
    public UserController(StringManipulationService stringService) {
        this.stringService = stringService;
    }

   
}