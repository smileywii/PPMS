package ppms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ppms.domain.Event;
import ppms.domain.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

  @Query("SELECT r FROM Result r WHERE LOWER(r.event) = LOWER(:id)")
  public List<Result> findAllByEventId(@Param("id") Long id);

  @Query("SELECT r FROM Result r WHERE r.event.id LIKE ?1")
  public List<Event> getAllResultsToEvent(Long id);

  @Query("SELECT r FROM Result r WHERE r.sport.id LIKE ?1")
  public List<Result> getAllResultBySport(long id);

}
