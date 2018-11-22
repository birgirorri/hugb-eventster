package project.persistence.entities;

import javax.persistence.*;
import project.persistence.entities.User;
import java.util.List;


@Entity
@Table(name = "Group") // If you want to specify a table name, you can do so here
public class Group{

    // Declare that this attribute is the id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
    
    private String groupName="group";
    private int GroupID=0;
    private String groupInfo ="info";
   
    private Boolean visable= true;
    private String username ="";
    private String email ="";
    
    public Group() {
    	
    }
   
    
    public Group(String groupName, String groupInfo, Boolean visable){
    	this.groupName = groupName;
    	this.groupInfo = groupInfo;
    	this.visable = visable;
    }
    
    public Group(String groupName, String groupInfo){
    	this.groupName = groupName;
    	this.groupInfo = groupInfo;
    	System.out.println("new Group created====================================");
    }
    
    public Group(String username, String email, String groupName) {
    	this.username = username;
    	this.email = email;
    	this.groupName = groupName;
    }
    
    public void addUser(User user) {
    	
    }
    
    public void kickUser(User user) {
    	
    }
    /* Á eftir að búa til Event klasa
    public void addEvent(Event event) {
    	
    }
    
    public void deleteEvent(Event event) {
    	
    }
    */
    
    public int getGroupID() {
    	return this.GroupID;
    }
    
    public void setGroupName(String newGroupName) {
    	this.groupName = newGroupName;
    }
    
    public String getGroupName() {
    	return this.groupName;
    }
    
    public void setGroupInfo(String info) {
    	this.groupInfo= info;
    }
    
    public String getGroupInfo() {
    	return this.groupInfo;
    }
    /*
    public void setMembers(List<User> members) {
    	this.members = members;
    }
    
    public List<User> getMembers(){
    	return this.members;
    }
    */
    public void setVisable(Boolean vis) {
    	this.visable = vis;
    }
    
    public Boolean getVisable() {
    	return this.visable;
    }
    
    /* þessi aðferð verður aldrei notuð, það verður frekar notað addEvent()
    public void setEvents(List<Event> eventList){
    	this.eventsList = eventList;
    }
    */
    
    /*
    public List<Event> getEvent(){
    	return this.eventsList;
    }
    */
    
    
}









