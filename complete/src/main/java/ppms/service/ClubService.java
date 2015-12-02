package ppms.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ppms.domain.Club;
import ppms.domain.Sport;
import ppms.dto.NewClubDTO;
import ppms.dto.UpdateClubDTO;
import ppms.repository.ClubRepository;

@Service
public class ClubService {

  @Autowired
  ClubRepository clubRepository;

  @Autowired
  SportService sportService;

  @Autowired
  MembershipService membershipService;

  public Club findOne(long id) {
    return clubRepository.findOne(id);
  }

  public List<Club> findAll() {
    return clubRepository.findAll();
  }

  public void save(@Valid Club club) {
    clubRepository.save(club);
  }

  public long count() {
    return clubRepository.count();
  }

  // TODO: exception if not 0
  public void delete(Long id) {
    if (membershipService.getAllMembersOfClub(id).size() == 0) {
      clubRepository.delete(id);
    }
  }

  public void save(NewClubDTO clubDTO) {
    Sport sport = sportService.findOne(clubDTO.getSportId());
    Club club = new Club(clubDTO, sport);
    club.setSport(sport);
    save(club);
  }

  public void update(UpdateClubDTO clubDTO) {
    Club club = clubRepository.findOne(clubDTO.getClubId());
    club.update(clubDTO);
    save(club);

  }
}
