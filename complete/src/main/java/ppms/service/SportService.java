package ppms.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ppms.domain.Sport;
import ppms.dto.NewSportDTO;
import ppms.dto.UpdateSportDTO;
import ppms.repository.SportRepository;

@Service
public class SportService {

  @Autowired
  SportRepository sportRepository;

  @Autowired
  PersonService personService;

  public Sport findOne(long id) {
    return sportRepository.findOne(id);
  }

  public List<Sport> findAll() {
    return sportRepository.findAll();
  }

  public void save(@Valid Sport sport) {
    sportRepository.save(sport);
  }

  public long count() {
    return sportRepository.count();
  }

  // TODO: exception if not 0
  public void delete(Long id) {
    if (personService.getAllPeopleDoingSport(id).size() == 0) {
      sportRepository.delete(id);
    }
  }

  public void save(NewSportDTO sportDTO) {
    save(new Sport(sportDTO.getName()));
  }

  public void update(UpdateSportDTO sportDTO) {
    Sport sport = sportRepository.findOne(sportDTO.getSportId());
    sport.setName(sportDTO.getName());
    save(sport);
  }
}
