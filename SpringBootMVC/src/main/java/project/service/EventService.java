package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.persistence.entities.PostitNote;
import project.persistence.entities.User;
import project.persistence.repositories.PostitNoteRepository;
import project.persistence.repositories.UserRepository;
import project.service.PostitNoteService;

import java.util.Collections;
import java.util.List;

@Service

public class EventService{
	
	 EventRepository repository;	
	 
	 @Autowired
	    public EventService(EventRepository repository) {
	        this.repository = repository;
	 	}
}