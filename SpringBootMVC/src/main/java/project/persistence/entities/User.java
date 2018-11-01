package project.persistence.entities;

import javax.persistence.*;

/**
 * The class for the Postit Note itself.
 * The system generates a table schema based on this class for this entity.
 * Be sure to annotate any entities you have with the @Entity annotation.
 */
@Entity
//@Table(name = "postitnote") // If you want to specify a table name, you can do so here
public class User{

    // Declare that this attribute is the id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userName;
    private String password;
    private String userID;
    private String birthday;
    private String phone;
    

    private String name;
    private String note;

    // Notice the empty constructor, because we need to be able to create an empty PostitNote to add
    // to our model so we can use it with our form
    public User() {
    }

    public User(String username, String userID, String name, String password){
        this.userName = username;
        this.userID = userID;
        this.password = password;
        this.name = name;   
    }

    public String getUserID() {
        return this.userID;
    }
    
    public 


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    // This is for easier debug.
    @Override
    public String toString() {
        return String.format(
                "Postit Note[name=%s, note=%s]",
                name,note);
    }
}