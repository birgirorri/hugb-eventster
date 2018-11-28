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

	@Autowired
	public EventController(EventService eventService, GroupService groupService , UserService userService) {
		this.eventService = eventService;
		this.groupService = groupService;
		this.userService = userService;
		
		Long langt = new Long(0);
		Long langt1 = new Long(1);
		Long langt2 = new Long(2);
		
		Event ammli = new Event("Afmæli", "Næstkomandi föstudag kl 8, langar mig til að halda smá teiti og þér er boðið, ekki láta þig vanta í fjörið. P.S. BYOB", 
				langt, "Birthday", "24.12.2018",  "25.12.2018", "Markaflöt 25", 120,true);
		Event tonleikar = new Event("Tónleikar", "Valdimar mun trylla líðin í  Eldborg næstkomandi föstudag, léttar veitingar verða á boðstólnum!", 
				langt, "Concert", "31.12.2018",  "01.01.2019", "Harpa Concert Hall", 250,true);
		Event bbq = new Event("BBQ", "Öllum boðið í pullupartý heima hjá mér, marínó, og það verður sko fjör. Ég mun plögga mat og drykkjum fyrir alla", 
				langt1, "BBQ", "10.02.2019", "10.02.2019", "Grafarvogur", 0,true);
		Event brudkaup = new Event("Göngum í það heilaga", "Á föstudaginn næstkomandi munum ég og Halli hanga í það heilaga og viljum við bjóða ykkur að koma og fagna því með okkur kl 8 í glersalnum í Kópavogi.", 
				langt, "Wedding", "30.11.2018",  "31.11.2018", "203 Kópavogur", 150,true);
		Event gigg = new Event("Trúbbakvöld", "Fullt af uppkomandi trúbbum munu fá að spreyta sig í kvöld á amateur trúbba kvöldinu okkar. láttu þig ekki vanta @Prikið í kvöld kl 22:00", 
				langt, "Gig", "08.01.2019",  "09.01.2019", "Prikið", 0,true);
		Event party = new Event("PARTY ALDARINNAR", "PARTY hjá Mér, MÆTTU!!", 
				langt2, "Party", "31.12.2018", "01.01.2019", "BRH", 0,true);
		eventService.createEvent(ammli);
		eventService.createEvent(tonleikar);
		eventService.createEvent(bbq);
		eventService.createEvent(brudkaup);
		eventService.createEvent(gigg);
		eventService.createEvent(party);
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
		
		
		User currentUser = userService.getCurrentUser();
		List<Group> allGroups = groupService.findAllGroups();
		List<Group> show = new ArrayList<Group>();
		
		for(Group g : allGroups) {
			if(g.getMembers().contains(currentUser.getEmail())) {
				show.add(g);
			}
		}
		
		model.addAttribute("groupsList", show );
		
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
		
		Boolean vis = true;
		Long langt = new Long(0);
		if (!groupID.equals("public")) {
			langt = new Long(Integer.parseInt(groupID));
			vis = false;
			System.out.println("prenta ut group id public");
		}
		
		
		System.out.println("prenta ut group id " + groupID); 
		String startYear = startDate.substring(0, 4);
		String endYear = endDate.substring(0, 4);
		String startMonth = startDate.substring(5, 7);
		String endMonth = endDate.substring(5, 7);
		String startDay = startDate.substring(8, 10);
		String endDay = endDate.substring(8, 10);
		
		String startdate = startDay + "." + startMonth + " " + startYear;
		String enddate = endDay + "." + endMonth + " " + endYear;
		
		
		int start = Integer.parseInt(startYear+startMonth+startDay);
		int end = Integer.parseInt(endYear+endMonth+endDay);
		
		String errorString = null;
		
		if((end-start)<0) {
			//error msg myndi vera hér
			return "createEvent";
		}
		
		Event newEvent = new Event(eventName, eventInfo, langt, tag, startdate, enddate, location, eventSeats,vis);
		
		
		

		model.addAttribute("errorMsg", errorString);
		
		eventService.createEvent(newEvent);
		
		User currentUser = userService.getCurrentUser();
		List<Event> allEvents = eventService.findAllEvents();
		List<Event> show = new ArrayList<Event>();
		
		for(Event e: allEvents) {
			if(e.getGroupID() < 1) {
				show.add(e);
			} else {
				System.out.println("getting group");
				Group g = groupService.findGroupByID(e.getGroupID());
				System.out.println("group gotten");
				if(!(g.getMembers().isEmpty())) {
					if(g.getMembers().contains(currentUser.getEmail())) {
						System.out.println("adding to show");
						show.add(e);
						System.out.println("added");
					}
				}
			}
		}
		
		model.addAttribute("eventList", show );

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
			@RequestParam("eventName") String eventName,@RequestParam("category") String category ,@RequestParam("eventDate") String date) {

		System.out.println("calling service function================================");
		
		List<Event> allEvents = eventService.findAllEvents();
		List<Event> searchName = new ArrayList<Event>();
		if(eventName =="") {
			searchName = eventService.findAllEvents();
		}
		else{
			searchName = eventService.findEventByName(eventName);
		}
		
		List<Event> result = new ArrayList<Event>();
		
		System.out.println(date +" öööööööö");
		
		int month = 0;
		
		switch(date){
		case "month":
			month = 0;
			break;
		case "jan":
			month = 1;
			break;
		case "feb":
			month = 2;
			break;
		case "mar":
			month = 3;
			break;
		case "apr":
			month = 4;
			break;
		case "may":
			month = 5;
			break;
		case "jun":
			month = 6;
			break;
		case "jul":
			month = 7;
			break;
		case "aug" :
			month = 8;
			break;
		case "sep":
			month = 9;
			break;
		case "oct":
			month = 10;
			break;
		case "nov":
			month = 11;
			break;
		case "dec":
			month = 12;
			break;
		};
		/*
		String yyyy = date.substring(0, 4);
		String mm = date.substring(5,7);
		String dd = date.substring(8,10);

		String sTime = yyyy+mm+dd;
		int time = Integer.parseInt(sTime);
		*/
		for(Event e : allEvents) {
			if( searchName.contains(e) ) {
				
				//String eStart_y = e.getStartDate().substring(6,10);
				String eStart_m = e.getStartDate().substring(3,5);
				
				//String eStart_d = e.getStartDate().substring(0,2);
			
				// String sStart = eStart_y+eStart_m+eStart_d;
				// int start = Integer.parseInt(sStart);
				
				// String eEnd_y = e.getEndDate().substring(6,10);
				String eEnd_m = e.getEndDate().substring(3,5);
				// String eEnd_d = e.getEndDate().substring(0,2);

				//String sEnd = eEnd_y+eEnd_m+eEnd_d;
				//int end = Integer.parseInt(sEnd);
				
				int eventStart = Integer.parseInt(eStart_m);
				int eventEnd = Integer.parseInt(eEnd_m);
				
				//if(time >= start && time <= end && e.getTag() == category) { result.add(e);}
				
				Boolean middle = (month > eventStart) && (month > eventEnd);
				if( (month ==  eventStart) || (month == eventEnd) || middle || (month == 0) ) {
					
					System.out.println(e.getTag());
					System.out.println(category);
					
					if(category.equals("Category")) {
						result.add(e);
						
					}
					else {
						if(e.getTag().equals(category)) {
							result.add(e);
						}
					}
					
				}
			
			}
		}

		model.addAttribute("eventList", result);
		// model.addAttribute("user", temp );

		System.out.println("done looking ================================");

		return "Events";
	}

	// Save the Postit Note that we received from the form
	@RequestMapping(value = "/showAllEvents", method = RequestMethod.GET)
	public String showAll(Model model) {

		System.out.println("SHOW ALL");
		System.out.println("SHOW ALL");
		User currentUser = userService.getCurrentUser();
		List<Event> allEvents = eventService.findAllEvents();
		List<Event> show = new ArrayList<Event>();
		
		for(Event e: allEvents) {
			if(e.getGroupID() < 1) {
				show.add(e);
			} else {
				System.out.println("getting group");
				Group g = groupService.findGroupByID(e.getGroupID());
				System.out.println("group gotten");
				if(!(g.getMembers().isEmpty())) {
					if(g.getMembers().contains(currentUser.getEmail())) {
						System.out.println("adding to show");
						show.add(e);
						System.out.println("added");
					}
				}
			}
		}
		
		model.addAttribute("eventList", show );

		return "Events";
	}

	@RequestMapping(value = "/event/{id}", method = RequestMethod.GET)
	public String goToViewEvent(@PathVariable Long id, Model model) {

		List<Event> eventview = new ArrayList<Event>();
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

	@RequestMapping(value = "/addmemberToGoing", method = RequestMethod.POST)
	public String addMemberToGoing(@ModelAttribute("userInfo") User user,Model model, @RequestParam("email") String email) {
		
		
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