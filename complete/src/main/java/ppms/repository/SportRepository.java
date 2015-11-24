package ppms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ppms.domain.Sport;

public interface SportRepository extends JpaRepository<Sport, Long> {

}
