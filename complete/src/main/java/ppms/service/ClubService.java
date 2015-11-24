package ppms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ppms.domain.Club;
import ppms.repository.ClubRepository;

@Service
public class ClubService {

  @Autowired
  ClubRepository clubRepository;

  public Club findOne(long id) {
    return clubRepository.findOne(id);
  }

  public List<Club> findAll() {
    return clubRepository.findAll();
  }

  public void save(Club club) {
    clubRepository.save(club);
  }

  public long count() {
    return clubRepository.count();
  }

  public void delete(Long id) {
    clubRepository.delete(id);
  }

}
