package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.persistence.entities.PostitNote;
import project.persistence.entities.User;
import project.persistence.entities.Group;
import project.persistence.repositories.PostitNoteRepository;
import project.persistence.repositories.UserRepository;
import project.service.PostitNoteService;

import java.util.Collections;
import java.util.List;

@Service

public class GroupService{
	
	
	 UserRepository repository;
	
	 
	 @Autowired
	    public GroupService(UserRepository repository) {
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
	    	
	    	User loginCheck = repository.validLogin(email);
	    	System.out.println( loginCheck.getPassword() + "-----------------------------------" );
	    	
	    	System.out.println("Service----------------------------------------");
	    	return true;
	    }
	    
	    public List<User> findAllUsersInGroup(String groupName){
	    	return repository.findGroupMembers(groupName);
	    }
	    
	    public void addMember(String username,String email, String groupName) {
	    	repository.save( new Group(username,email,groupName));
	    }
	    
	    
}