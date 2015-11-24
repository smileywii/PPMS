package ppms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ppms.domain.Event;
import ppms.repository.EventRepository;

@Service
public class EventService {

  @Autowired
  EventRepository eventRepository;

  public Event findOne(long id) {
    return eventRepository.findOne(id);
  }

  public List<Event> findAll() {
    return eventRepository.findAll();
  }

  public long count() {
    return eventRepository.count();
  }

  public void delete(Long id) {
    eventRepository.delete(id);
  }

  public void save(Event event) {
    eventRepository.save(event);

  }
}
