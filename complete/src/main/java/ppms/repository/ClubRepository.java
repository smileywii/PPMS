package ppms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ppms.domain.Club;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {

}
