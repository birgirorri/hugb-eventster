package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.persistence.entities.Event;
import project.persistence.repositories.*;

import java.util.Collections;
import java.util.List;

@Service

public class EventService{
	
	
	 EventRepository repository;
	
	 
	 @Autowired
	    public EventService(EventRepository repository) {
	        this.repository = repository;
	    }
	 

	    public Event createEvent(Event event) {
	        return repository.save(event);
	    }

	    
	    public void delete(Event event) {
	        repository.delete(event);
	    }
	    
	    public List<Event> findAllEvents() {
	        return repository.findAll();
	    }
	    
	    public Event findEventByID(Long eventID){
	    	return repository.findOne(eventID);
	    }
	    
	    /*public List<Group> findUserByGroup(int GroupID) {
	    	return repository.findGroupByID(groupID);
	    }
	    */
	    
	    public void updateUser(Event event){
	    	
	    }
	    
	    public List<Event> sortEvent(String by, List<Event> events){
	    	return events;
	    }
}