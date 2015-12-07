package ppms.service;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ppms.domain.Club;
import ppms.domain.DateHolder;
import ppms.domain.Membership;
import ppms.domain.Person;
import ppms.domain.Sport;
import ppms.dto.NewPersonDTO;
import ppms.dto.UpdatePersonDTO;
import ppms.repository.ClubRepository;
import ppms.repository.PersonRepository;
import ppms.repository.SportRepository;

@Service
public class PersonService {

  @Autowired
  PersonRepository personRepository;

  @Autowired
  MembershipService membershipService;

  @Autowired
  ClubRepository clubRepository;

  @Autowired
  SportRepository sportRepository;

  public Person findOne(long id) {
    return personRepository.findOne(id);
  }

  public List<Person> findAll() {
    return personRepository.findAll();
  }

  public Person save(@Valid Person person) {
    return personRepository.save(person);
  }

  public long count() {
    return personRepository.count();
  }

  public void delete(Long id) {
    personRepository.delete(id);
  }

  public Integer numberOfPeopleDoingSport(Long sportId) {
    return personRepository.numberOfPeopleDoingSport(sportId);
  }

  public Integer getAllClubCountDoingSport(Long sportId) {
    return personRepository.numberOfClubDoingSport(sportId);
  }

  public void registerPerson(NewPersonDTO personDTO) {
    Person person = save(new Person(personDTO, clubRepository.findOne(personDTO.getClubId()).getSport()));
    Membership membership = new Membership(clubRepository.findOne(personDTO.getClubId()), person, new Date(),
        new Date());

    membershipService.save(membership);
  }

  // TODO: endDate
  public void update(UpdatePersonDTO personDTO) {
    Person person = personRepository.findOne(personDTO.getPersonId());
    Sport sport = sportRepository.findOne(personDTO.getSportId());

    if (sport.getId() != person.getSport().getId()) {
      if (!person.getMemberships().isEmpty()) {
        long currClubId = getCurrentClubId(person.getMemberships());
        if (currClubId != 0) {
          Membership membership = membershipService.findOne(currClubId);
          membership.setEndDate(new Date());
          membershipService.save(membership);
        }
      }
    }

    save(person.updatePerson(personDTO, sport));
  }

  public void newClub(Long personId, DateHolder dateHolder, long clubId) {
    Membership membership = new Membership();
    Person person = personRepository.findOne(personId);
    Club club = clubRepository.findOne(clubId);

    if (person != null && club != null) {
      if (person.getSport().getId() != club.getId()) {
        person.setSport(club.getSport());
        personRepository.save(person);
      }
      membership = new Membership(club, person, dateHolder.getStartDate(), dateHolder.getEndDate());
      membershipService.save(membership);
    }

  }

  public List<Person> getAllPeopleDoingSport(Long sportId) {
    return personRepository.getAllPeopleDoingSport(sportId);
  }

  private long getCurrentClubId(List<Membership> memberships) {
    for (Membership membership : memberships) {
      if (membership.getEndDate().compareTo(new Date()) > 0) {
        return membership.getId();
      }
    }
    return 0;
  }

  public int numberOfPeopleDoingSportAtAge(long id, String filter) {
    filter = filter.replace("\"", "");
    int count = 0;
    List<Person> people = personRepository.getAllPeopleDoingSport(id);
    for (Person person : people) {
      if (isPersonAgeInTheIntervall(person.getAge(), filter)) {
        count++;
      }
    }
    return count;
  }

  private boolean isPersonAgeInTheIntervall(int age, String filter) {
    if (filter.equals("Mindet mutat")) {
      return true;
    }
    if (filter.contains("-")) {
      String interval[] = filter.split("-");
      if (Integer.parseInt(interval[0].trim()) <= age && Integer.parseInt(interval[1].trim()) >= age) {
        return true;
      }

    } else if (filter.contains("<")) {
      if (20 > age) {
        return true;
      }

    } else {
      if (age >= 40) {
        return true;
      }
    }
    return false;
  }
}
