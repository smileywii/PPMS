package hello.repository;

import hello.domain.PhysicalDevelopment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhysicalDevelopmentRepository extends JpaRepository<PhysicalDevelopment, Long> {

}
