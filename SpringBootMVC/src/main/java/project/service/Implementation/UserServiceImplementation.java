package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.persistence.entities.User;
import project.persistence.repositories.UserRepository;
import project.service.UserService;

import java.util.Collections;
import java.util.List;

@Service

public class UserServiceImplementation implements UserService{
    
    UserRepository repository;
    User current_user;
    

    @Autowired
    public UserServiceImplementation(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User createUser(User user) {
        System.out.println("fer í service");
        return repository.save(user);
    }

    
    @Override
    public void delete(User user) {
        repository.delete(user);
    }
    
    @Override
    public List<User> findAllUsers() {
        return repository.findAll();
    }
    
    @Override
    public User findUserByID(Long userID){
        return repository.findOne(userID);
    }
    
    @Override
    public List<User> findByUsername(String userName){
        return repository.findByUsername(userName);
    }
    
    @Override
    public User getCurrentUser() {
    	return this.current_user;
    }
    
    @Override 
    public void setCurrentUser(User user) {
    	this.current_user = user;
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
    public User findByEmail(String email){
        return repository.findByEmail(email);
    }
    
    @Override
    public User findWhoLoggedIn() {
    	return repository.findWhoLoggedIn();
    }

    
}
