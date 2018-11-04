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
import java.util.List;


@Controller
public class EventController {
	EventService eventService;
	
	public EventController(EventService eventService) {
        this.eventService = eventService;
    }
}