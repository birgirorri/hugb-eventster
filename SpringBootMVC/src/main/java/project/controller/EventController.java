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
import project.persistence.entities.User;
import project.service.*;
import project.service.StringManipulationService;
import project.service.UserService;
import java.util.List;


@Controller
public class EventController {
	EventService eventService;
	
	public EventController(EventService eventService) {
        this.eventService = eventService;
    }
	
    @RequestMapping(value = "/Events", method = RequestMethod.GET)
    public String event(Model model,@ModelAttribute("event") Event event){

      
    	model.addAttribute("eventList", eventService.findAllEvents());
    	
        return "Events";
    }
    
    @RequestMapping(value = "/createEvent", method = RequestMethod.GET)
    public String createEvent(Model model){

        return "createEvent";
    }
    
    @RequestMapping(value = "/ViewEvent", method = RequestMethod.GET)
    public String viewEvent(Model model){

        return "ViewEvent";
    }
    
    @RequestMapping(value = "/addEvent", method = RequestMethod.POST )
    public String UserViewUser(@ModelAttribute("event") Event event,@RequestParam("eventName") String eventName, @RequestParam("eventInfo") String eventInfo,@RequestParam("groupID") long groupID, Model model ){

        // Save the Postit Note that we received from the form
    	
    	Event newEvent = new Event(eventName, eventInfo, groupID);
    	System.out.println("búið til event: " + newEvent.getEventName());
        eventService.createEvent(newEvent);

        // Return the view
        return "Events";
    }

    // Method that returns the correct view for the URL /postit/{name}
    // The {name} part is a Path Variable, and we can reference that in our method
    // parameters as a @PathVariable. This enables us to create dynamic URLs that are
    // based on the data that we have.
    // This method finds all Postit Notes posted by someone with the requested {name}
    // and returns a list with all those Postit Notes.
    @RequestMapping(value = "/eventObj/{eventName}", method = RequestMethod.GET)
    public String eventFromID(long  eventID, Model model){

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
    
    
    @RequestMapping(value = "/findEvent", method = RequestMethod.POST )
    public String SearchUser(@ModelAttribute("event") Event event,Model model ,@RequestParam("eventName") long eventID){
    
    	System.out.println("calling service function================================");
    	
    	
    		model.addAttribute("eventList", eventService.findEventByID(eventID) );
    		//model.addAttribute("user", temp );
    
    	System.out.println("done looking ================================");
    	
    return "Events";
    }
        // Save the Postit Note that we received from the form
    @RequestMapping(value = "/showAllEvents", method = RequestMethod.POST )
    public String showAll(Model model){
    
    	System.out.println("SHOW ALL");
    	
    	model.addAttribute("eventList", eventService.findAllEvents());
    	//model.addAttribute("user", temp );
    
    	
    	
    return "Events";
    }
}