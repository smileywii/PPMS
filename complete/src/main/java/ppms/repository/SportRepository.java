package ppms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ppms.domain.Sport;

@Repository
public interface SportRepository extends JpaRepository<Sport, Long> {

}
