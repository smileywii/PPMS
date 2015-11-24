package ppms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ppms.domain.Sport;
import ppms.repository.SportRepository;

@Service
public class SportService {

  @Autowired
  SportRepository sportRepository;

  public Sport findOne(long id) {
    return sportRepository.findOne(id);
  }

  public List<Sport> findAll() {
    return sportRepository.findAll();
  }

  public void save(Sport sport) {
    sportRepository.save(sport);
  }

  public long count() {
    return sportRepository.count();
  }

  public void delete(Long id) {
    sportRepository.delete(id);
  }

}
