package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.persistence.entities.Event;
import project.persistence.entities.User;
import project.persistence.repositories.*;

import java.util.Collections;
import java.util.List;

public interface EventService{
	
        
    public Event createEvent(Event event);

    
    public void delete(Event event);
    
    public List<Event> findAllEvents();
    
    public Event findEventByID(Long eventID);
    
    public List<Event> findEventByName(String name);
    
    public void updateUser(Event event);
    
    public List<Event> sortEvent(String by, List<Event> events);
    
    public void goingToEvent(User user, Long id);
    
    public Event getCurrentEvent();
    
    public void setCurrentEvent(Event event);
}