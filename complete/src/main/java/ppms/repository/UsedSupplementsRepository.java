package ppms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ppms.domain.Person;
import ppms.domain.UsedSupplement;

@Repository
public interface UsedSupplementsRepository extends JpaRepository<UsedSupplement, Long> {

  @Query("SELECT person FROM UsedSupplement u WHERE u.supplement.id LIKE ?1")
  List<Person> getAllPeopleUsingThisSupplement(Long id);

  // @Query("SELECT count(*) FROM UsedSupplement u WHERE u.supplement.name LIKE ?1")
  // int getAllPeopleCountUsingThisBrand(String brand);

  // @Query("SELECT count(*) FROM UsedSupplements u WHERE u.supplement.id LIKE ?1 AND (SELECT id FROM Membership m WHERE m.person.")
  // List<MembershipService> getAllClubUsingThisSupplement(Long id);

}
