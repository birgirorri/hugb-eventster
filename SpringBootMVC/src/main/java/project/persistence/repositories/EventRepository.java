package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.*;

import java.util.List;

/**
 * By extending the {@link JpaRepository} we have access to powerful methods.
 * For detailed information, see:
 * http://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
 * http://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
 *
 */

public interface EventRepository extends JpaRepository<Event, Long> {

	Event save(Event event);

	Comment save(Group group);

	void delete(Event event);

	List<Event> findAll();

	// If we need a custom query that maybe doesn't fit the naming convention used
	// by the JPA repository,
	// then we can write it quite easily with the @Query notation, like you see
	// below.
	// This method returns all PostitNotes where the length of the name is equal or
	// greater than 3 characters.
	@Query(value = "SELECT p FROM Event p where length(p.eventName) >= 3 ")
	List<Event> findAllWithNameLongerThan3Chars();

	// Instead of the method findAllReverseOrder() in PostitNoteService.java,
	// We could have used this method by adding the words
	// ByOrderByIdDesc, which mean: Order By Id in a Descending order
	//
	List<Event> findAllByOrderByIdDesc();

	@Query(value = "SELECT p FROM Event p WHERE p.id = ?1")
	Event findOne(Long id);

	@Query(value = "SELECT p FROM Event p WHERE p.eventName LIKE %?1% ")
	List<Event> findByEventName(String eventName);

	@Query(value = "SELECT p FROM Comment p WHERE p.eventID = eID")
	List<Comment> findComments(String eventID);

}