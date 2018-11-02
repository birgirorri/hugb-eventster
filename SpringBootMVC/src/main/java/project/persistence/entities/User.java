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
   
    private String username;
    private String password;
    
    private String birthday ="1";
    private String phone ="2";
    private String zodiac ="3";

    private String email;
   

    // Notice the empty constructor, because we need to be able to create an empty PostitNote to add
    // to our model so we can use it with our form
    public User() {
    }

    public User(String username, String password, String userID){
        this.username = username;
        this.password = password;
        this.email = userID;   
        System.out.println("new user created  " + username);
    }
    

    public String getUsername() {
        return this.username;
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
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public String getEmail() {
    	return this.email;
    }
    
    public void setZodiac(String zodiac) {
    	this.zodiac = zodiac;
    }
    
    public String getZodiac() {
    	return this.zodiac;
    }
   

    // This is for easier debug.
    /*@Override
    public String toString() {
        return String.format(
                "Postit Note[name=%s, note=%s]",
                email,note);
    }*/
}