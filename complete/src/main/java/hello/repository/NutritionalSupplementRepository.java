package hello.repository;

import hello.domain.NutritionalSupplement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionalSupplementRepository extends JpaRepository<NutritionalSupplement, Long> {

}
