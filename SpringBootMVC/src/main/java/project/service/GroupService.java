package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.persistence.entities.PostitNote;
import project.persistence.entities.User;
import project.persistence.entities.Event;
import project.persistence.entities.Group;
import project.persistence.repositories.PostitNoteRepository;
import project.persistence.repositories.GroupRepository;
import project.service.PostitNoteService;

import java.util.Collections;
import java.util.List;

public interface GroupService{

	public Group addGroup(Group group);
	
	public void delete(Group group);
	
	public List<Group> findAllGroups();
	
	public Group findGroupByID(Long ID);
	
	public List<Group> findByName(String name);
	
	public void updateUser(User user);
	
	public List<User> sortUser(String by, List<User> users);
	
	public List<User> findAllUsersInGroup(String groupName);
	
	public void addMember(String username,String email, String groupName);
	
}