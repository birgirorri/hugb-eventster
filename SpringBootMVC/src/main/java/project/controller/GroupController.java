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
import project.service.GroupService;
import java.util.List;


@Controller
public class GroupController {

    // Instance Variables
    //StringManipulationService stringService;
	GroupService groupService;

    // Dependency Injection
    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }
    
    // To call this method, enter "localhost:8080/user" into a browser
    @RequestMapping(value = "/Group", method = RequestMethod.GET)
    public String user(Model model){

      
    
        return "Group";
    }
    
    @RequestMapping(value = "/addMember", method = RequestMethod.POST )
    public String UserViewUser(@ModelAttribute("members") User user,Model model ,@RequestParam("username") String username,
    		@RequestParam("email") String email,@RequestParam("groupName") String groupName ){

        // Save the Postit Note that we received from the form
    	User newUser = new User(username,email);
        groupService.addMember(username,email,groupName);

        
        
        // Here we get all the Postit Notes (in a reverse order) and add them to the model
        model.addAttribute("memberList", groupService.findAllUsersInGroup(groupName) );

        // Add a new Postit Note to the model for the form
        // If you look at the form in PostitNotes.jsp, you can see that we
        // reference this attribute there by the name `postitNote`.
        model.addAttribute("members", newUser );

        // Return the view
        return "Group";
    }
}
