package project.persistence.entities;

import javax.persistence.*;
import java.util.List;

/**
 * The class for the Postit Note itself. The system generates a table schema
 * based on this class for this entity. Be sure to annotate any entities you
 * have with the @Entity annotation.
 */
@Entity
@Table(name = "Comments") // If you want to specify a table name, you can do so here
public class Comment {

	// Declare that this attribute is the id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int eventID;
	private String text;
	private String userID;

	public Comment(int eventID, String text, String userID) {
		this.eventID = eventID;
		this.text = text;
		this.userID = userID;
	}

	public Long getCommentID() {
		return this.id;
	}

	public int getEventID() {
		return this.eventID;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	public String getUserID() {
		return this.userID;
	}
}