package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.persistence.entities.Event;
import project.persistence.repositories.*;
import project.service.EventService;

import java.util.Collections;
import java.util.List;

@Service
public class EventServiceImplementation implements EventService{
	
	
	 EventRepository repository;
	
	 
	 @Autowired
	    public EventServiceImplementation (EventRepository repository) {
	        this.repository = repository;
	    }
	 

		@Override
	    public Event createEvent(Event event) {
	        return repository.save(event);
	    }

		
		@Override
	    public void delete(Event event) {
	        repository.delete(event);
	    }
		
		@Override
	    public List<Event> findAllEvents() {
	        return repository.findAll();
	    }
		
		@Override
	    public Event findEventByID(Long eventID){
	    	return repository.findOne(eventID);
	    }
		
		@Override
	    public List<Event> findEventByName(String name){
	    	return repository.findByEventName(name);
	    }
	    
	    /*public List<Group> findUserByGroup(int GroupID) {
	    	return repository.findGroupByID(groupID);
	    }
	    */
		
		@Override
	    public void updateUser(Event event){
	    	
	    }
		
		@Override
	    public List<Event> sortEvent(String by, List<Event> events){
	    	return events;
	    }
}