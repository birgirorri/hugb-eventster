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

public class UserService{
	
	
	 UserRepository repository;
	
	 
	 @Autowired
	    public UserService(UserRepository repository) {
	        this.repository = repository;
	    }
	 

	    public User createUser(User user) {
	        return repository.save(user);
	    }

	    
	    public void delete(User user) {
	        repository.delete(user);
	    }
	    
	    public List<User> findAllUsers() {
	        return repository.findAll();
	    }
	    
	    public User findUserByID(Long userID){
	    	return repository.findOne(userID);
	    }
	    
	    public List<User> findByUsername(String userName){
	    	return repository.findByUsername(userName);
	    }
	    
	    
	    /*public List<Group> findUserByGroup(int GroupID) {
	    	return repository.findGroupByID(groupID);
	    }
	    */
	    
	    public void updateUser(User user){
	    	
	    }
	    
	    public List<User> sortUser(String by, List<User> users){
	    	return users;
	    }
	    
	    public Boolean validateLogin(String email, String password){
	    	
	    	User loginCheck = repository.validLogin(email, password);
	    	System.out.println( loginCheck.getPassword() + "-----------------------------------" );
	    	
	    	System.out.println("Service----------------------------------------");
	    	return true;
	    }
	    
	    
}
