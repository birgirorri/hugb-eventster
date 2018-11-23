package project.persistence.entities;

import javax.persistence.*;
import project.persistence.entities.*;
import java.util.List;
import java.util.ArrayList;

import java.util.Date;

/**
 * The class for the Postit Note itself. The system generates a table schema
 * based on this class for this entity. Be sure to annotate any entities you
 * have with the @Entity annotation.
 */
@Entity
@Table(name = "Events") // If you want to specify a table name, you can do so here
public class Event {

	// Declare that this attribute is the id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String eventName;
	private String eventInfo;
	private Long groupID;
	private ArrayList<Comment> comments;
	private ArrayList<String> tags;

	public Event() {
	}

	public Event(String eventName, String eventInfo, Long groupID) {

		this.eventName = eventName;
		this.eventInfo = eventInfo;
		this.groupID = groupID;

	}

	public void addComment(Comment comment) {
		this.comments.add(comment);
	}

	public void deleteComment(Comment comment) {
		this.comments.remove(comment);
	}

	public Long getEventID() {
		return this.id;
	}

	public void setEventName(String name) {
		this.eventName = name;
	}

	public String getEventName() {
		return this.eventName;
	}

	public void setEventInfo(String info) {
		this.eventInfo = info;
	}

	public String getEventInfo() {
		return this.eventInfo;
	}

	public void addTag(String tag) {
		this.tags.add(tag);
	}

	public void setGroupID(Long groupID) {
		this.groupID = groupID;
	}

	public Long getGroupID() {
		return this.groupID;
	}
}
