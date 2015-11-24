package ppms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ppms.domain.Membership;

public interface MembershipRepository extends JpaRepository<Membership, Long> {

  // @Query("SELECT r FROM Result r WHERE LOWER(r.event) = LOWER(:id)")
  // public List<Result> findAllByEventId(@Param("id") Long id);

}
