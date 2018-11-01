package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.persistence.entities.PostitNote;
import project.persistence.entities.User;
import project.service.StringManipulationService;
import project.service.UserService;


@Controller
public class UserController {

    // Instance Variables
    //StringManipulationService stringService;
	UserService userService;

    // Dependency Injection
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    // To call this method, enter "localhost:8080/user" into a browser
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(Model model){

        // Here we will show how to add attributes to a model and send it to the view

        // Since this small example is for a user, let's create some attributes
        // that users might usually have in a system
        String name = "Rincewind";
        String job  = "Wizzard";
        String email = "rincewizz@unseenuni.edu";
        String description = "most likely to survive in a dungeon dimension.";


        // Since we want our attributes regarding the user always in the same format,
        // we are going to convert some strings using our StringManipulationService

        // Let's assume that the name, job and description always have
        // the first character in upper case
        
        //name = stringService.convertsFirstCharInStringToUpperCase(name);
        //job = stringService.convertsFirstCharInStringToUpperCase(job);
       // description = stringService.convertsFirstCharInStringToUpperCase(description);

        // Let's assume that we always want e-mail in lower case
        //email = stringService.convertStringToLowerCase(email);


        // Now let's add the attributes to the model
      
        
        model.addAttribute("name","Marinó");
        model.addAttribute("job","Húgbó");
        model.addAttribute("email","mak78");
        model.addAttribute("description","Marinó er bestur");

        // By adding attributes to the model, we can pass information from the controller
        // to the view (the .jsp file).
        // Look at the User.jsp file in /main/webapp/WEB-INF/jsp/ to see how the data is accessed
        return "User";
    }
    
    
    @RequestMapping(value = "/addUser", method = RequestMethod.POST )
    
    public String UserViewUser(@ModelAttribute("user") User user,Model model ,@RequestParam("username") String username, @RequestParam("password") String password,@RequestParam("userID") String userID){

        // Save the Postit Note that we received from the form
        userService.createUser(user);

        
        
        // Here we get all the Postit Notes (in a reverse order) and add them to the model
        model.addAttribute("user", userService.findAllUsers() );

        // Add a new Postit Note to the model for the form
        // If you look at the form in PostitNotes.jsp, you can see that we
        // reference this attribute there by the name `postitNote`.
        model.addAttribute("user", new User());

        // Return the view
        return "User";
    }

    // Method that returns the correct view for the URL /postit/{name}
    // The {name} part is a Path Variable, and we can reference that in our method
    // parameters as a @PathVariable. This enables us to create dynamic URLs that are
    // based on the data that we have.
    // This method finds all Postit Notes posted by someone with the requested {name}
    // and returns a list with all those Postit Notes.
   
   
}