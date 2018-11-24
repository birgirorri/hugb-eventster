package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.persistence.entities.PostitNote;
import project.persistence.entities.User;
import project.persistence.entities.Event;
import project.persistence.entities.Group;
import project.persistence.repositories.PostitNoteRepository;
import project.persistence.repositories.GroupRepository;
import project.service.GroupService;
import project.service.PostitNoteService;

import java.util.Collections;
import java.util.List;

@Service
public class GroupServiceImplementation implements GroupService{
	
	
	 GroupRepository repository;
	 
	 Group currentGroup;
	
	 
	 @Autowired
	public GroupServiceImplementation (GroupRepository repository) {
	    this.repository = repository;
	}
	
	/*
	public Group createUser(Group group) {
	    return repository.save(group);
	}
	*/   
	@Override
	public Group addGroup(Group group) {
		System.out.println(group.getGroupName() +"=============================" + group.getGroupInfo() );
		
		
		return repository.save(group);
	}
	
	@Override
	public void delete(Group group) {
	    repository.delete(group);
	}
	
	@Override
	public List<Group> findAllGroups() {
		System.out.println("finding groups============================");
	    return repository.findAll();
	}
	/*  
	public User findUserByID(Long userID){
		return repository.findOne(userID);
	}
	*/
	
	@Override
	public Group findGroupByID(Long ID){
		return repository.findOne(ID);
	}
	
	@Override
	public List<Group> findByName(String name){
		return repository.findByName(name);
	}
	
	
	/*public List<Group> findUserByGroup(int GroupID) {
		return repository.findGroupByID(groupID);
	}
	*/
	
	@Override
	public void updateUser(User user){
		
	}
	
	@Override
	public List<User> sortUser(String by, List<User> users){
		return users;
	}
	
	
	@Override
	public List<User> findAllUsersInGroup(Long id){
		return repository.findGroupMembers(id);
	}
	
	@Override
	public void addMember(User user, Long id) {
		Group group = repository.findOne(id);
		
		group.addUser(user);
		
		repository.save(group);
		System.out.println("group saved =========");
		
	}
	
	@Override
	public Group getCurrentGroup() {
		System.out.println(this.currentGroup.getGroupName() +"=========================================");
		return this.currentGroup;
	}
	
	@Override
	public void setCurrentGroup(Group group) {
		this.currentGroup = group;
	}
}