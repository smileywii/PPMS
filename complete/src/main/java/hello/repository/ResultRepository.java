package hello.repository;

import hello.domain.Result;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

  @Query("SELECT r FROM Result r WHERE LOWER(r.event) = LOWER(:id)")
  public List<Result> findAllByEventId(@Param("id") Long id);

}
