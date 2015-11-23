package hello.service;

import hello.domain.Club;
import hello.repository.ClubRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
