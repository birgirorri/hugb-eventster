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
import project.service.*;
import project.service.UserService;
import project.service.GroupService;
import java.util.List;
import java.util.ArrayList;

@Controller
public class EventController {
	EventService eventService;
	GroupService groupService;
	UserService userService;

	public EventController(EventService eventService, GroupService groupService , UserService userService) {
		this.eventService = eventService;
		this.groupService = groupService;
		this.userService = userService;
	}

	@RequestMapping(value = "/Events", method = RequestMethod.GET)
	public String event(Model model, @ModelAttribute("event") Event event) {

		model.addAttribute("eventList", eventService.findAllEvents());

		List<Event> ev = eventService.findAllEvents();

		if (!ev.isEmpty()) {
			System.out.println(ev.get(0).getEventName() + "========================");
		}

		return "Events";
	}

	@RequestMapping(value = "/createEvent", method = RequestMethod.GET)
	public String createEvent(Model model) {
		
		model.addAttribute("groupsList", groupService.findAllGroups());
		return "createEvent";
	}

	@RequestMapping(value = "/ViewEvent", method = RequestMethod.GET)
	public String viewEvent(Model model) {

		return "ViewEvent";
	}

	@RequestMapping(value = "/addEvent", method = RequestMethod.POST)
	public String addEvent(@ModelAttribute("event") Event event, @RequestParam("eventName") String eventName,
			@RequestParam("eventInfo") String eventInfo, @RequestParam("category") String tag, @RequestParam("startDate") 
			String startDate, @RequestParam("endDate") String endDate, Model model) {

		// Save the Postit Note that we received from the form
		long langt = 0;
		System.out.println(tag);
		Event newEvent = new Event(eventName, eventInfo, langt, tag, startDate, endDate);
		
		String errorString = "";
		int startYear = Integer.parseInt(startDate.substring(0, 4));
		int endYear = Integer.parseInt(endDate.substring(0, 4));
		int startMonth = Integer.parseInt(startDate.substring(5, 7));
		int endMonth = Integer.parseInt(endDate.substring(5, 7));
		int startDay = Integer.parseInt(startDate.substring(8, 10));
		int endDay = Integer.parseInt(endDate.substring(8, 10));
		System.out.println(startDay + "/" + startMonth + "/" + startYear);
		System.out.println(endDay + "/" + endMonth + "/" + endYear);
		//if()

		model.addAttribute("errorMsg", errorString);
		
		model.addAttribute("eventList", eventService.findAllEvents());

		
		eventService.createEvent(newEvent);
		// Return the view
		return "Events";
	}

	// Method that returns the correct view for the URL /postit/{name}
	// The {name} part is a Path Variable, and we can reference that in our method
	// parameters as a @PathVariable. This enables us to create dynamic URLs that
	// are
	// based on the data that we have.
	// This method finds all Postit Notes posted by someone with the requested
	// {name}
	// and returns a list with all those Postit Notes.
	@RequestMapping(value = "/eventObj/{eventName}", method = RequestMethod.GET)
	public String eventFromID(long eventID, Model model) {

		System.out.println("------------------------------------------------------------------------------------hello");
		// Get all Postit Notes with this name and add them to the model
		model.addAttribute("eventList", eventService.findEventByID(eventID));

		// Add a new Postit Note to the model for the form
		// If you look at the form in PostitNotes.jsp, you can see that we
		// reference this attribute there by the name `postitNote`.
		model.addAttribute("event", new Event());

		// Return the view
		return "Events";
	}

	@RequestMapping(value = "/findEvent", method = RequestMethod.POST)
	public String SearchUser(@ModelAttribute("event") Event event, Model model,
			@RequestParam("eventName") String eventName) {

		System.out.println("calling service function================================");

		model.addAttribute("eventList", eventService.findEventByName(eventName));
		// model.addAttribute("user", temp );

		System.out.println("done looking ================================");

		return "Events";
	}

	// Save the Postit Note that we received from the form
	@RequestMapping(value = "/showAllEvents", method = RequestMethod.POST)
	public String showAll(Model model) {

		System.out.println("SHOW ALL");

		model.addAttribute("eventList", eventService.findAllEvents());
		// model.addAttribute("user", temp );

		return "Events";
	}

	@RequestMapping(value = "/event/{id}", method = RequestMethod.GET)
	public String goToViewEvent(@PathVariable Long id, Model model) {

		List<Event> eventview = new ArrayList();
		eventview.add(eventService.findEventByID(id));
		
		eventService.setCurrentEvent(eventService.findEventByID(id));

		model.addAttribute("currentEvent", eventview);
		
		Event currentEvent = eventService.getCurrentEvent();
		
		ArrayList<String> memberEmails = currentEvent.getGoing();
		ArrayList<User> members = new ArrayList<User>();
		
		for(String em : memberEmails) {
			System.out.println(em);
			User u = userService.findByEmail(em);
			members.add(u);
			System.out.println(u.getEmail());
		}
		
		model.addAttribute("usersGoing", members );
		
		
	
		// Return the view
		return "ViewEvent";
	}

	@RequestMapping(value = "/LoadEvent", method = RequestMethod.GET)
	public String preloadEvent(Model model) {
		long langt = 0;
		Event amli = new Event("afmæli", "partý hjá bubba", langt, "Birthday", "2018-12-24",  "2018-12-25");
		Event tnlkr = new Event("tónleikar", "valdimar í eldborg", langt, "Concert", "2018-12-31",  "2019-1-1");
		Event bbq = new Event("bbq", "pullupartý hjá marinó", langt, "BBQ", "2019-2-10", "2019-2-10");
		eventService.createEvent(amli);
		eventService.createEvent(tnlkr);
		eventService.createEvent(bbq);
		
		model.addAttribute("eventList", eventService.findAllEvents());

		return "Events";
	}
	
	@RequestMapping(value = "/addmemberToGoing", method = RequestMethod.POST)
	public String addMemberToGoing(@ModelAttribute("userInfo") User user,Model model,@RequestParam("userName") String userName,
			@RequestParam("email") String email) {
		
		
		User new_member = userService.findByEmail(email);
		Event currentEvent = eventService.getCurrentEvent();
		
		eventService.goingToEvent(new_member, currentEvent.getEventID() );
		Event updatedEvent = eventService.findEventByID(currentEvent.getEventID());
	
		ArrayList<String> memberEmails = updatedEvent.getGoing();
		ArrayList<User> members = new ArrayList<User>();
		
		for(String em : memberEmails) {
			System.out.println(em);
			User u = userService.findByEmail(em);
			members.add(u);
			System.out.println(u.getEmail());
		}
		
		model.addAttribute("usersGoing", members );
		
		return goToViewEvent(updatedEvent.getEventID(), model);
	}
	
	

}