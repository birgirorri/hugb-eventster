package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.persistence.entities.Event;
import project.persistence.entities.Group;
import project.persistence.entities.User;
import project.service.UserService;
import project.service.GroupService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

	// Instance Variables
	// StringManipulationService stringService;
	UserService userService;
	GroupService groupService;

	// Dependency Injection
	@Autowired
	public UserController(UserService userService,GroupService groupService) {
		this.userService = userService;
		this.groupService = groupService;
	}

	// To call this method, enter "localhost:8080/user" into a browser
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(Model model) {

		// Here we will show how to add attributes to a model and send it to the view

		// Since this small example is for a user, let's create some attributes
		// that users might usually have in a system
		String name = "Rincewind";
		String job = "Wizzard";
		String email = "rincewizz@unseenuni.edu";
		String description = "most likely to survive in a dungeon dimension.";

		// Since we want our attributes regarding the user always in the same format,
		// we are going to convert some strings using our StringManipulationService

		// Let's assume that the name, job and description always have
		// the first character in upper case

		// name = stringService.convertsFirstCharInStringToUpperCase(name);
		// job = stringService.convertsFirstCharInStringToUpperCase(job);
		// description =
		// stringService.convertsFirstCharInStringToUpperCase(description);

		// Let's assume that we always want e-mail in lower case
		// email = stringService.convertStringToLowerCase(email);

		// Now let's add the attributes to the model

		model.addAttribute("name", "Marinó");
		model.addAttribute("job", "Húgbó");
		model.addAttribute("email", "mak78");
		model.addAttribute("description", "Marinó er bestur");

		// By adding attributes to the model, we can pass information from the
		// controller
		// to the view (the .jsp file).
		// Look at the User.jsp file in /main/webapp/WEB-INF/jsp/ to see how the data is
		// accessed
		return "User";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String UserViewUser(@ModelAttribute("user") User user, Model model,
			@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("email") String email) {

		// Save the Postit Note that we received from the form

		User newUser = new User(username, password, email);
		userService.createUser(newUser);

		System.out.println(" sdf" + username);

		// Here we get all the Postit Notes (in a reverse order) and add them to the
		// model
		model.addAttribute("userList", userService.findAllUsers());

		// Add a new Postit Note to the model for the form
		// If you look at the form in PostitNotes.jsp, you can see that we
		// reference this attribute there by the name `postitNote`.
		model.addAttribute("user", newUser);

		// Return the view
		return "User";
	}

	// Method that returns the correct view for the URL /postit/{name}
	// The {name} part is a Path Variable, and we can reference that in our method
	// parameters as a @PathVariable. This enables us to create dynamic URLs that
	// are
	// based on the data that we have.
	// This method finds all Postit Notes posted by someone with the requested
	// {name}
	// and returns a list with all those Postit Notes.
	@RequestMapping(value = "/userObj/{username}", method = RequestMethod.GET)
	public String postitNoteGetNotesFromName(@PathVariable String userName, Model model) {

		System.out.println("------------------------------------------------------------------------------------hello");
		// Get all Postit Notes with this name and add them to the model
		model.addAttribute("userList", userService.findByUsername(userName));

		// Add a new Postit Note to the model for the form
		// If you look at the form in PostitNotes.jsp, you can see that we
		// reference this attribute there by the name `postitNote`.
		model.addAttribute("user", new User());

		// Return the view
		return "User";
	}

	@RequestMapping(value = "/findUser", method = RequestMethod.POST)
	public String SearchUser(@ModelAttribute("user") User user, Model model,
			@RequestParam("username") String username) {

		System.out.println("calling service function================================");
		List<User> search = userService.findByUsername(username);

		model.addAttribute("userList", search);
		// model.addAttribute("user", temp );

		System.out.println("done looking ================================");

		return "User";
	}
	
	@RequestMapping(value = "/findUserbyEmail", method = RequestMethod.POST)
	public String SearchUserEmail(@ModelAttribute("user") User user, Model model,
			@RequestParam("email") String email) {

		System.out.println("calling service function================================");
		List<User> search = userService.findbyEmailSubstring(email);
		
		
		model.addAttribute("userList", search);
		// model.addAttribute("user", temp );

		System.out.println("done looking ================================");

		return "User";
	}

	// Save the Postit Note that we received from the form
	@RequestMapping(value = "/showAllUsers", method = RequestMethod.POST)
	public String showAll(Model model) {

		System.out.println("SHOW ALL");

		model.addAttribute("userList", userService.findAllUsers());
		// model.addAttribute("user", temp );

		return "User";
	}

	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public String showMyPage(Model model) {
		
		//System.out.println(userService.findWhoLoggedIn().getEmail());
		
		List<User> userview = new ArrayList();
		userview.add(userService.getCurrentUser() );

		model.addAttribute("currentSession", userview);
		
		return "myPage";
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public String postitNoteGetNotesFromName(@PathVariable long id, Model model) {
		
		
		List<User> userview = new ArrayList();
		userview.add(userService.findUserByID(id));

		model.addAttribute("currentUser", userview);

	
		// Return the view
		return "ViewUser";
	}
	
	
	@RequestMapping(value = "/changeUserInfo" , method = RequestMethod.POST)
	public String editUserInfo(Model model,
			@RequestParam("birthday") String birthday, @RequestParam("phone") String phone,
			@RequestParam("zodiac") String zodiac) {
		
		User user = userService.getCurrentUser();
		
		if(!birthday.isEmpty()) {
		user.setBirthday(birthday);	
		}
		
		if(!phone.isEmpty()) {
			user.setPhone(phone);
		}
		
		if(!zodiac.isEmpty()) {
			user.setZodiac(zodiac);	
		}
		
		userService.createUser(user);// save changes
		return showMyPage(model);
		
		
		
	}
	@RequestMapping(value = "/signOut" , method = RequestMethod.GET)
	public String editUserInfo(Model model) {
		userService.setCurrentUser(null);
		return "Index";
	}
	
	@RequestMapping(value = "/showGroupsImIn", method = RequestMethod.POST)
	public String showGroupsImIn(Model model) {

		System.out.println("SHOW ALL");
		List<Group> search = groupService.findAllGroups();
		
		User user = userService.getCurrentUser();
		
		List<Group> show = new ArrayList<Group>();
		
		for(Group g : search) {
			if(g.getMembers().contains(user.getEmail())) {
				show.add(g);
			}
		}


		model.addAttribute("groupsList", show);
		// model.addAttribute("user", temp );

		return showMyPage(model);
	}
	
	
	@RequestMapping(value = "/findGroupsImIn", method = RequestMethod.POST)
	public String SearchGroupsImin(@ModelAttribute("groups") Group group, Model model,
			@RequestParam("groupName") String groupName) {

		System.out.println("calling service function================================");
		List<Group> search = groupService.findByName(groupName);
		User user = userService.getCurrentUser();
		
		List<Group> show = new ArrayList<Group>();
		
		for(Group g : search) {
			if(g.getMembers().contains(user.getEmail())) {
				show.add(g);
			}
		}

		model.addAttribute("groupsList", show);
		// model.addAttribute("user", temp );

		System.out.println("done looking ================================");

		return showMyPage(model);
	}
	
	
	

}