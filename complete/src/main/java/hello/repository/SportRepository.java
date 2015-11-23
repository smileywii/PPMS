package hello.repository;

import hello.domain.Sport;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SportRepository extends JpaRepository<Sport, Long> {

}
