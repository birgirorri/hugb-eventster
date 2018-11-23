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
import project.persistence.entities.Event;
import project.persistence.entities.Group;
import project.service.GroupService;

import java.util.ArrayList;
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
    
    @RequestMapping(value = "/createGroup", method = RequestMethod.GET)
    public String createEvent(Model model){

        return "createGroup";
    }
    
    @RequestMapping(value = "/addGroup", method = RequestMethod.POST )
    public String groupViewGroup(@ModelAttribute("groups") Group groups,Model model ,
    		@RequestParam("groupInfo") String groupInfo,@RequestParam("groupName") String groupName ){

        // Save the Postit Note that we received from the form
    	Group newGroup = new Group(groupName,groupInfo);
    	System.out.println(newGroup.getGroupName() + " --- " + newGroup.getGroupInfo());
        groupService.addGroup(newGroup);
    	System.out.println("Group added===============================================");


        
        
        // Here we get all the Postit Notes (in a reverse order) and add them to the model
       model.addAttribute("groupsList", groupService.findAllGroups() );
        

        // Add a new Postit Note to the model for the form
        // If you look at the form in PostitNotes.jsp, you can see that we
        // reference this attribute there by the name `postitNote`.
        model.addAttribute("groups", newGroup);

        System.out.println("virkar===============================================");
        // Return the view
        return "Group";
    }
    
    @RequestMapping(value = "/findGroups", method = RequestMethod.POST )
    public String SearchUser(@ModelAttribute("groups") Group group,Model model ,@RequestParam("groupName") String groupName){
    
    	System.out.println("calling service function================================");
    	List<Group> search = groupService.findByName(groupName);
    	
    	
    		model.addAttribute("groupsList", groupService.findByName(groupName) );
    		//model.addAttribute("user", temp );
    
    	System.out.println("done looking ================================");
    	
    return "Group";
    }
    
    @RequestMapping(value = "/group/{id}", method = RequestMethod.GET)
    public String goToViewGroup(@PathVariable Long id, Model model){

    	
    	List<Group> groupview = new ArrayList();
    	groupview.add(groupService.findGroupByID(id) );
    	
    	model.addAttribute("currentGroup", groupview);
    	
        // Get all Postit Notes with this name and add them to the model
        //model.addAttribute("postitNotes", postitNoteService.findByName(name));

        // Add a new Postit Note to the model for the form
        // If you look at the form in PostitNotes.jsp, you can see that we
        // reference this attribute there by the name `postitNote`.
        //model.addAttribute("postitNote", new PostitNote());

        // Return the view
        return "ViewGroup";
    }
    
    @RequestMapping(value = "/showAllGroups", method = RequestMethod.POST )
    public String showAll(Model model){
    
    	System.out.println("SHOW ALL");
    	
    	model.addAttribute("groupsList", groupService.findAllGroups() );
    	//model.addAttribute("user", temp );
    
    	
    	
    return "Group";
    }
    
    @RequestMapping(value = "/LoadGroup", method = RequestMethod.GET)
	public String preloadEvent(Model model) {
    	Group annunaki = new Group("Nörd", "allir meðlimir nörd");
		Group bubb = new Group("bubb og co.", "vinir hans bubba");
		Group brh = new Group("BRH BOYS","adam og bróðir hans");
		groupService.addGroup(annunaki);
		groupService.addGroup(bubb);
		groupService.addGroup(brh);
		
		return "Group";
	}
    
    
}
