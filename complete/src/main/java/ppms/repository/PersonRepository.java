package ppms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ppms.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

  @Query("SELECT count(p.name) FROM Person p WHERE p.sport.id LIKE ?1")
  Integer numberOfPeopleDoingSport(Long id);

  @Query("SELECT count(c.name) FROM Club c WHERE c.sport.id LIKE ?1")
  Integer numberOfClubDoingSport(Long id);

  @Query("SELECT p FROM Person p WHERE p.sport.id LIKE ?1")
  List<Person> getAllPeopleDoingSport(Long id);

}
