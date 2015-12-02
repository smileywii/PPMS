package ppms.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ppms.domain.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

  @Query("SELECT e FROM Event e WHERE e.date BETWEEN ?1 AND ?2")
  List<Event> allEventsBetweenDates(Date from, Date to);

}
