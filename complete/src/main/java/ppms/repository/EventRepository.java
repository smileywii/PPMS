package ppms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ppms.domain.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
