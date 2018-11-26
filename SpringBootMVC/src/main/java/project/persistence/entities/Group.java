package project.persistence.entities;

import javax.persistence.*;
import project.persistence.entities.User;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "Groups") // If you want to specify a table name, you can do so here
public class Group {

	// Declare that this attribute is the id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String group_name;
	// private int GroupID;
	private String info;
	private ArrayList<String> members = new ArrayList<String>();
	private boolean isVisable;
	
	public Group() {

	}

	public Group(String groupName, String groupInfo, Boolean visable) {
		this.group_name = groupName;
		this.info = groupInfo;
		this.isVisable = visable;
	}

	public Group(String groupName, String groupInfo) {
		this.group_name = groupName;
		this.info = groupInfo;
		System.out.println("new Group created====================================");
	}

	public Group(String username, String email, String groupName) {
		// this.username = username;
		// this.email = email;
		this.group_name = groupName;
	}

	public void addUser(User user) {
		System.out.println(user.getUsername() +"----------------------");
		
		
		this.members.add(user.getEmail());
		System.out.println(user.getUsername() +"----------------------");
	}

	public void kickUser(User user) {

	}
	/*
	 * Á eftir að búa til Event klasa public void addEvent(Event event) {
	 * 
	 * }
	 * 
	 * public void deleteEvent(Event event) {
	 * 
	 * }
	 */

	public Long getGroupID() {
		return this.id;
	}

	public void setGroupName(String newGroupName) {
		this.group_name = newGroupName;
	}

	public String getGroupName() {
		return this.group_name;
	}

	public void setGroupInfo(String info) {
		this.info = info;
	}

	public String getGroupInfo() {
		return this.info;
	}

	
	public void setMembers(ArrayList<String> members) { 
		this.members = members; 
	}
	 
	public ArrayList<String> getMembers(){
		return this.members; 
	}
	 
	public void setVisable(Boolean vis) {
		 this.isVisable = vis;
	}

	public Boolean getVisable(){
		return this.isVisable;
	}

	/*
	 * þessi aðferð verður aldrei notuð, það verður frekar notað addEvent() public
	 * void setEvents(List<Event> eventList){ this.eventsList = eventList; }
	 */

	/*
	 * public List<Event> getEvent(){ return this.eventsList; }
	 */

}
