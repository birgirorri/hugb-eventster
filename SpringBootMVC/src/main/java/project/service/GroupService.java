package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.persistence.entities.PostitNote;
import project.persistence.entities.User;
import project.persistence.entities.Event;
import project.persistence.entities.Group;
import project.persistence.repositories.PostitNoteRepository;
import project.persistence.repositories.GroupRepository;

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
	
	public List<User> findAllUsersInGroup(Long id);
	
	public void addMember(User user, Long id);
	
	public Group getCurrentGroup();
	
	public void setCurrentGroup(Group group);
	
}