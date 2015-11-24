package ppms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ppms.domain.UsedSupplement;

public interface UsedSupplementsRepository extends JpaRepository<UsedSupplement, Long> {

}
