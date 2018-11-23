package project.service;

import project.persistence.entities.User;
import java.util.List;

public interface UserService {
    public User createUser(User user);

    public void delete(User user);

    public List<User> findAllUsers();

    public User findUserByID(Long userID);

    public List<User> findByUsername(String userName);

    public void updateUser(User user);

    public List<User> sortUser(String by, List<User> users);
//
	public User findByEmail(String email);
	
    public User findWhoLoggedIn();
}