package project.persistence.entities;

import javax.persistence.*;

/**
 * The class for the Postit Note itself.
 * The system generates a table schema based on this class for this entity.
 * Be sure to annotate any entities you have with the @Entity annotation.
 */
@Entity
@Table(name = "User") // If you want to specify a table name, you can do so here
public class User{

    // Declare that this attribute is the id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
    
    //@Column(name = "id", unique = true, columnDefinition = "serial")
   
    private String userName;
    private String password;
    private String userID;
    private String birthday;
    private String phone;
    private String zodiac;

    private String name;
    private String note;

    // Notice the empty constructor, because we need to be able to create an empty PostitNote to add
    // to our model so we can use it with our form
    public User() {
    }

    public User(String username, String userID, String name, String password){
        this.userName = username;
        
        this.password = password;
        this.name = name;   
    }

    public String getUserID() {
        return this.userID;
    }
    

    public String getUsername() {
        return this.userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
    	return this.password;
    }
    
    public void setBirthday(String birthday) {
    	this.birthday = birthday;
    }
    
    public String getBirthday(){
    	return this.birthday;
    }
    
    public void setPhone(String phone) {
    	this.phone = phone;
    }
    
    public String getPhone() {
    	return this.phone;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public void setZodiac(String zodiac) {
    	this.zodiac = zodiac;
    }
    
    public String getZodiac() {
    	return this.zodiac;
    }
   

    // This is for easier debug.
    @Override
    public String toString() {
        return String.format(
                "Postit Note[name=%s, note=%s]",
                name,note);
    }
}