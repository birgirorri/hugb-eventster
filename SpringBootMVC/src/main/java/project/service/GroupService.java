package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.persistence.entities.PostitNote;
import project.persistence.entities.User;
import project.persistence.entities.Group;
import project.persistence.repositories.PostitNoteRepository;
import project.persistence.repositories.GroupRepository;
import project.service.PostitNoteService;

import java.util.Collections;
import java.util.List;

@Service

public class GroupService{
	
	
	 GroupRepository repository;
	
	 
	 @Autowired
	    public GroupService(GroupRepository repository) {
	        this.repository = repository;
	    }
	 

	    public Group createUser(Group group) {
	        return repository.save(group);
	    }
	    
	    public Group addGroup(Group group) {
	    	System.out.println(group.getGroupName() +"=============================");
	    	return repository.save(group);
	    }

	    
	    public void delete(Group group) {
	        repository.delete(group);
	    }
	    
	    public List<Group> findAllGroups() {
	        return repository.findAll();
	    }
	    
	    public User findUserByID(Long userID){
	    	return repository.findOne(userID);
	    }
	    
	    public List<Group> findByName(String name){
	    	return repository.findByName(name);
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
	    
	  
	    public List<User> findAllUsersInGroup(String groupName){
	    	return repository.findGroupMembers(groupName);
	    }
	    
	    public void addMember(String username,String email, String groupName) {
	    	repository.save( new Group(username,email,groupName));
	    }
	    
	    
}