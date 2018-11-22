package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.persistence.entities.PostitNote;
import project.persistence.entities.User;
import project.persistence.entities.Group;

import java.util.List;

/**
 * By extending the {@link JpaRepository} we have access to powerful methods.
 * For detailed information, see:
 * http://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
 * http://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
 *
 */

public interface UserRepository extends JpaRepository<User, Long> {

	User save(User user);
	Group save(Group group);

    void delete(User user);

    List<User> findAll();

    // If we need a custom query that maybe doesn't fit the naming convention used by the JPA repository,
    // then we can write it quite easily with the @Query notation, like you see below.
    // This method returns all PostitNotes where the length of the name is equal or greater than 3 characters.
    @Query(value = "SELECT p FROM User p where length(p.username) >= 3 ")
    List<User> findAllWithNameLongerThan3Chars();

    // Instead of the method findAllReverseOrder() in PostitNoteService.java,
    // We could have used this method by adding the words
    // ByOrderByIdDesc, which mean: Order By Id in a Descending order
    //
    List<User> findAllByOrderByIdDesc();

    @Query(value = "SELECT p FROM User p WHERE p.id = ?1")
    User findOne(Long id);

    @Query(value = "SELECT p FROM User p WHERE p.username LIKE %?1% ")
    List<User> findByUsername(String username);
    
    
    @Query(value = "SELECT p FROM User p WHERE p.email = ?1 AND p.password = ?2")
    User validLogin(String email, String password);
    
    @Query(value = "SELECT p FROM Group p WHERE p.groupName = gName")
    List<User> findGroupMembers(String groupName);
    
    
    
} 
