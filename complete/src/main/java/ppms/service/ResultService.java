package ppms.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ppms.domain.Event;
import ppms.domain.Person;
import ppms.domain.Result;
import ppms.dto.NewResultDTO;
import ppms.dto.UpdateResultDTO;
import ppms.repository.EventRepository;
import ppms.repository.ResultRepository;

@Service
public class ResultService {

  @Autowired
  ResultRepository resultsRepository;

  @Autowired
  PersonService personService;

  @Autowired
  EventRepository eventService;

  public List<Result> findAllByEventId(Long id) {
    return resultsRepository.findAllByEventId(id);
  }

  public void save(NewResultDTO resultDTO) {
    Person person = personService.findOne(resultDTO.getPersonId());
    Event event = eventService.findOne(resultDTO.getEventId());
    Result result = new Result(resultDTO.getPosition(), event, person, person.getSport());

    save(result);
  }

  public void update(UpdateResultDTO resultDTO) {
    Result result = resultsRepository.findOne(resultDTO.getResultId());
    result.setPosition(resultDTO.getPosition());
    save(result);
  }

  private void save(@Valid Result result) {
    resultsRepository.save(result);
  }

  public void delete(Long id) {
    resultsRepository.delete(resultsRepository.findOne(id));
  }

  public long getPersonIdByResultId(Long resultId) {
    return resultsRepository.findOne(resultId).getPerson().getId();
  }

  public List<Event> getAllResultsToEvent(Long id) {
    return resultsRepository.getAllResultsToEvent(id);
  }
}
