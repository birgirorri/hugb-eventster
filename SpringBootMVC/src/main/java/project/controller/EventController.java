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
			String startDate, @RequestParam("endDate") String endDate, @RequestParam("eventLocation") String location, 
			@RequestParam("maxSeats") int eventSeats, @RequestParam("group") String groupID, Model model) {

		// Save the Postit Note that we received from the form
		Long langt = new Long(0);
		if (!groupID.equals("public")) {
			langt = new Long(Integer.parseInt(groupID));
		}
		
		int startYear = Integer.parseInt(startDate.substring(0, 4));
		int endYear = Integer.parseInt(endDate.substring(0, 4));
		int startMonth = Integer.parseInt(startDate.substring(5, 7));
		int endMonth = Integer.parseInt(endDate.substring(5, 7));
		int startDay = Integer.parseInt(startDate.substring(8, 10));
		int endDay = Integer.parseInt(endDate.substring(8, 10));
		
		String startdate = startDay + "." + startMonth + " " + startYear;
		String enddate = endDay + "." + endMonth + " " + endYear;
		
		
		int start = startYear+startMonth+startDay;
		int end = endYear+endMonth+endDay;
		
		String errorString = null;
		
		if((end-start)<0) {
			//error msg myndi vera hér
			return "createEvent";
		}
		
		Event newEvent = new Event(eventName, eventInfo, langt, tag, startdate, enddate, location, eventSeats);

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
		Long langt = new Long(0);
		Long langt1 = new Long(1);
		Long langt2 = new Long(2);
		
		Event ammli = new Event("Afmæli", "Næstkomandi föstudag kl 8, langar mig til að halda smá teiti og þér er boðið, ekki láta þig vanta í fjörið. P.S. BYOB", 
				langt, "Birthday", "24.12.2018",  "25.12.2018", "Markaflöt 25", 120);
		Event tonleikar = new Event("Tónleikar", "Valdimar mun trylla líðin í  Eldborg næstkomandi föstudag, léttar veitingar verða á boðstólnum!", 
				langt, "Concert", "31.12.2018",  "01.01.2019", "Harpa Concert Hall", 250);
		Event bbq = new Event("BBQ", "Öllum boðið í pullupartý heima hjá mér, marínó, og það verður sko fjör. Ég mun plögga mat og drykkjum fyrir alla", 
				langt1, "BBQ", "10.02.2019", "10.02.2019", "Grafarvogur", 0);
		Event brudkaup = new Event("Göngum í það heilaga", "Á föstudaginn næstkomandi munum ég og Halli hanga í það heilaga og viljum við bjóða ykkur að koma og fagna því með okkur kl 8 í glersalnum í Kópavogi.", 
				langt, "Wedding", "30.11.2018",  "31.11.2018", "203 Kópavogur", 150);
		Event gigg = new Event("Trúbbakvöld", "Fullt af uppkomandi trúbbum munu fá að spreyta sig í kvöld á amateur trúbba kvöldinu okkar. láttu þig ekki vanta @Prikið í kvöld kl 22:00", 
				langt, "Gig", "08.01.2019",  "09.01.2019", "Prikið", 0);
		Event party = new Event("PARTY ALDARINNAR", "PARTY hjá Mér, MÆTTU!!", 
				langt2, "Party", "31.12.2018", "01.01.2019", "BRH", 0);
		eventService.createEvent(ammli);
		eventService.createEvent(tonleikar);
		eventService.createEvent(bbq);
		eventService.createEvent(brudkaup);
		eventService.createEvent(gigg);
		eventService.createEvent(party);
		
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
	
	@RequestMapping(value="/attend",method = RequestMethod.GET)
	public String attendThisEvent(Model model) {

		User new_member = userService.getCurrentUser();
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