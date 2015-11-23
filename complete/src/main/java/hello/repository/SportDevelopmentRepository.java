package hello.repository;

import hello.domain.SportDevelopment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SportDevelopmentRepository extends JpaRepository<SportDevelopment, Long> {

}
