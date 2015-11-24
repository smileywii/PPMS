package ppms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ppms.domain.NutritionalSupplement;

@Repository
public interface NutritionalSupplementRepository extends JpaRepository<NutritionalSupplement, Long> {

}
