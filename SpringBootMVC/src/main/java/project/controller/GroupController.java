package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.persistence.entities.User;
import project.persistence.entities.Event;
import project.persistence.entities.Group;
import project.service.GroupService;
import project.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GroupController {

	// Instance Variables
	// StringManipulationService stringService;
	GroupService groupService;
	UserService userService;

	// Dependency Injection
	@Autowired
	public GroupController(GroupService groupService, UserService userService) {
		this.groupService = groupService;
		this.userService = userService;
	}

	// To call this method, enter "localhost:8080/user" into a browser
	@RequestMapping(value = "/Group", method = RequestMethod.GET)
	public String user(Model model) {
		return "Group";
	}

	@RequestMapping(value = "/createGroup", method = RequestMethod.GET)
	public String createEvent(Model model) {

		return "createGroup";
	}

	@RequestMapping(value = "/addGroup", method = RequestMethod.POST)
	public String groupViewGroup(@ModelAttribute("groups") Group groups, Model model,
			@RequestParam("groupInfo") String groupInfo, @RequestParam("groupName") String groupName,@RequestParam("groupVisable") String visable) {

		// Save the Postit Note that we received from the form
		
		User user = userService.getCurrentUser();
		System.out.println(visable);
		Boolean vis = false;
		
		System.out.println(visable + "----------------------");

		if(visable.contains("private")) {
			vis = false;
		}
		else if(visable.contains("public") )  {
			vis = true;
		}
		Group newGroup = new Group(groupName, groupInfo,vis);
		
		System.out.println(newGroup.getGroupName() + " --- " + newGroup.getGroupInfo());
		groupService.addGroup(newGroup);
		System.out.println("Group added===============================================");
		groupService.addMember(user, newGroup.getGroupID());
		// Here we get all the Postit Notes (in a reverse order) and add them to the
		// model
		

		// Add a new Postit Note to the model for the form
		// If you look at the form in PostitNotes.jsp, you can see that we
		// reference this attribute there by the name `postitNote`.
		model.addAttribute("groups", newGroup);

		System.out.println("virkar===============================================");
		// Return the view
		return showAll(model);
	}

	@RequestMapping(value = "/findGroups", method = RequestMethod.POST)
	public String SearchUser(@ModelAttribute("groups") Group group, Model model,
			@RequestParam("groupName") String groupName) {

		System.out.println("calling service function================================");
		List<Group> search = groupService.findByName(groupName);
		User user = userService.getCurrentUser();
		
		List<Group> show = new ArrayList<Group>();
		
		for(Group g : search) {
			if(g.getVisable() || g.getMembers().contains(user.getEmail())) {
				show.add(g);
			}
		}

		model.addAttribute("groupsList", show);
		// model.addAttribute("user", temp );

		System.out.println("done looking ================================");

		return "Group";
	}

	@RequestMapping(value = "/group/{id}", method = RequestMethod.GET)
	public String goToViewGroup(@PathVariable Long id, Model model) {

		List<Group> groupview = new ArrayList();
		
		Group view = groupService.findGroupByID(id);
		groupview.add(view);

		model.addAttribute("currentGroup", groupview);
		
		groupService.setCurrentGroup(view);
		
		ArrayList<String> memberEmails = view.getMembers();
		ArrayList<User> members = new ArrayList<User>();
		
		for(String em : memberEmails) {
			User u = userService.findByEmail(em);
			members.add(u);
			System.out.println(u.getEmail());
		}
		
		model.addAttribute("membersOfgroup", members );

		// Get all Postit Notes with this name and add them to the model
		// model.addAttribute("postitNotes", postitNoteService.findByName(name));

		// Add a new Postit Note to the model for the form
		// If you look at the form in PostitNotes.jsp, you can see that we
		// reference this attribute there by the name `postitNote`.
		// model.addAttribute("postitNote", new PostitNote());

		// Return the view
		return "ViewGroup";
	}

	@RequestMapping(value = "/showAllGroups", method = RequestMethod.POST)
	public String showAll(Model model) {

		System.out.println("SHOW ALL");
		List<Group> search = groupService.findAllGroups();
		
		User user = userService.getCurrentUser();
		
		List<Group> show = new ArrayList<Group>();
		
		for(Group g : search) {
			if(g.getVisable() || g.getMembers().contains(user.getEmail())) {
				show.add(g);
			}
		}


		model.addAttribute("groupsList", show);
		// model.addAttribute("user", temp );

		return "Group";
	}

	@RequestMapping(value = "/LoadGroup", method = RequestMethod.GET)
	public String preloadEvent(Model model) {
		Group annunaki = new Group("Nörd", "allir meðlimir nörd",true);
		Group bubb = new Group("bubb og co.", "vinir hans bubba",true);
		Group brh = new Group("BRH BOYS", "adam og bróðir hans",true);
		groupService.addGroup(annunaki);
		groupService.addGroup(bubb);
		groupService.addGroup(brh);

		return "Group";
	}
	
	@RequestMapping(value = "/findUserToAdd", method = RequestMethod.POST)
	public String SearchUser(@ModelAttribute("user") User user, Model model,
			@RequestParam("username") String username) {

		Group currentGroup = groupService.getCurrentGroup();
		System.out.println("calling service function================================");
		List<User> search = userService.findByUsername(username);

		model.addAttribute("userList", search);
		// model.addAttribute("user", temp );

		System.out.println("done looking ================================");

		return goToViewGroup(currentGroup.getGroupID(),model);
	}
	
	@RequestMapping(value = "/addmember", method = RequestMethod.POST)
	public String addMemberToGroup(@ModelAttribute("userInfo") User user,Model model,@RequestParam("userName") String userName,
			@RequestParam("email") String email) {
		
		User new_member = userService.findByEmail(email);
		
		Group currentGroup = groupService.getCurrentGroup();
		
		groupService.addMember(new_member, currentGroup.getGroupID() );
		
		Group updatedGroup = groupService.findGroupByID(currentGroup.getGroupID());
		
		ArrayList<String> memberEmails = updatedGroup.getMembers();
		ArrayList<User> members = new ArrayList<User>();
		
		for(String em : memberEmails) {
			User u = userService.findByEmail(em);
			members.add(u);
			System.out.println(u.getEmail());
		}
		
		model.addAttribute("membersOfgroup", members );
		
		return goToViewGroup(updatedGroup.getGroupID(),model);
	}
	
	@RequestMapping(value = "/showUsersToAdd", method = RequestMethod.POST)
	public String showUsersToAdd(Model model) {

		System.out.println("SHOW ALL");
		Group currentGroup = groupService.getCurrentGroup();
		

		model.addAttribute("userList", userService.findAllUsers());
		// model.addAttribute("user", temp );

		return goToViewGroup(currentGroup.getGroupID(),model);
	}
	
	@RequestMapping(value = "/addMember/{email}", method = RequestMethod.GET)
	public String addThisUser(@ModelAttribute("userInfo") User user,Model model,@PathVariable String email) {
		
		User new_member = userService.findByEmail(email);
		
		Group currentGroup = groupService.getCurrentGroup();
		
		groupService.addMember(new_member, currentGroup.getGroupID() );
		
		Group updatedGroup = groupService.findGroupByID(currentGroup.getGroupID());
		
		ArrayList<String> memberEmails = updatedGroup.getMembers();
		ArrayList<User> members = new ArrayList<User>();
		
		for(String em : memberEmails) {
			User u = userService.findByEmail(em);
			members.add(u);
			System.out.println(u.getEmail());
		}
		
		model.addAttribute("membersOfgroup", members );
		
		return goToViewGroup(updatedGroup.getGroupID(),model);
	}
	

	
	
	
	
	

}
