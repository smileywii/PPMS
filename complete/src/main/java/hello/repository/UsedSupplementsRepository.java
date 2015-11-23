package hello.repository;

import hello.domain.UsedSupplement;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsedSupplementsRepository extends JpaRepository<UsedSupplement, Long> {

}
