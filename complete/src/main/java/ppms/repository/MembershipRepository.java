package ppms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ppms.domain.Membership;
import ppms.domain.Person;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {

  @Query("SELECT person FROM Membership m WHERE m.club.id LIKE ?1")
  List<Person> getAllMembersOfClub(long id);

  // @Query("SELECT r FROM Result r WHERE LOWER(r.event) = LOWER(:id)")
  // public List<Result> findAllByEventId(@Param("id") Long id);

}
