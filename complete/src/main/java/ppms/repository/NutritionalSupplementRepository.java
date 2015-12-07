package ppms.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ppms.domain.NutritionalSupplement;

@Repository
public interface NutritionalSupplementRepository extends JpaRepository<NutritionalSupplement, Long> {

  @Query("SELECT n.brand FROM NutritionalSupplement n")
  Set<String> findAllBrand();

}
