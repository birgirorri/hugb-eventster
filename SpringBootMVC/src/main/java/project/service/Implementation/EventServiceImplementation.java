package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.persistence.entities.Event;
import project.persistence.entities.Group;
import project.persistence.entities.User;
import project.persistence.repositories.*;
import project.service.EventService;

import java.util.Collections;
import java.util.List;

@Service
public class EventServiceImplementation implements EventService{
	
	
	 EventRepository repository;
	 
	 private Event currentEvent;
	
	 
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
		
		@Override
		public void goingToEvent(User user, Long id) {
			System.out.println("find by id");
			Event event = repository.findOne(id);
			
			System.out.println("adding if not in");
			
			
			System.out.println("adding if not " + user.getEmail());
			event.addToGoing(user.getEmail() );
			System.out.println("adding if not " + user.getEmail());
			
			System.out.println("save event");
			repository.save(event);
		}
		
		@Override
		public Event getCurrentEvent() {
			return this.currentEvent;
		}
		
		@Override
		public void setCurrentEvent(Event event) {
			this.currentEvent = event;
		}
}