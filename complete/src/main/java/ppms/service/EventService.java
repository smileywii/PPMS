package ppms.service;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ppms.domain.Event;
import ppms.dto.NewEventDTO;
import ppms.dto.UpdateEventDTO;
import ppms.repository.EventRepository;

@Service
public class EventService {

  @Autowired
  EventRepository eventRepository;

  @Autowired
  ResultService resultService;

  public Event findOne(long id) {
    return eventRepository.findOne(id);
  }

  public List<Event> findAll() {
    return eventRepository.findAll();
  }

  public long count() {
    return eventRepository.count();
  }

  // TODO: exception when not 0
  public void delete(Long id) {
    if (resultService.getAllResultsToEvent(id).size() == 0) {
      eventRepository.delete(id);
    }
  }

  public void save(@Valid Event event) {
    eventRepository.save(event);
  }

  public void update(UpdateEventDTO eventDTO) {
    Event event = eventRepository.findOne(eventDTO.getEventId());
    event.update(eventDTO);
    save(event);
  }

  public List<Event> allEventsBetweenDate(Date from, Date to) {
    return eventRepository.allEventsBetweenDates(from, to);
  }

  public void save(NewEventDTO eventDTO) {
    Event event = new Event(eventDTO);
    save(event);
  }
}
