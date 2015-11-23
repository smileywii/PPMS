package hello.repository;

import hello.domain.NutritionalSupplement;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NutritionalSupplementsRepository extends JpaRepository<NutritionalSupplement, Long> {

}
