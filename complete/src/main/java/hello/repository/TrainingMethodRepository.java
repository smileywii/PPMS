package hello.repository;

import hello.domain.TrainingMethod;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingMethodRepository extends JpaRepository<TrainingMethod, Long> {

}
