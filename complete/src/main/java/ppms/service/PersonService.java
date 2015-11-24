package ppms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ppms.domain.Club;
import ppms.domain.DateHolder;
import ppms.domain.Membership;
import ppms.domain.Person;
import ppms.domain.Sport;
import ppms.repository.ClubRepository;
import ppms.repository.MembershipRepository;
import ppms.repository.PersonRepository;
import ppms.repository.SportRepository;

@Service
public class PersonService {

  @Autowired
  PersonRepository personRepository;

  @Autowired
  MembershipRepository membershipRepository;

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

  public void save(Person person) {
    personRepository.save(person);
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

  public Integer numberOfClubDoingSport(Long sportId) {
    return personRepository.numberOfClubDoingSport(sportId);
  }

  public void registerPerson(Person person, long clubId) {
    person.setSport(clubRepository.findOne(clubId).getSport());
    Person savedPerson = personRepository.save(person);
    Membership membership = new Membership(clubRepository.findOne(clubId), savedPerson, new Date(), new Date());

    membershipRepository.save(membership);
  }

  // TODO: endDate
  public void update(Person person, long personId, long sportId) {
    Person existingPerson = personRepository.findOne(personId);
    Sport existingSport = sportRepository.findOne(sportId);
    person.setSport(existingSport);
    existingPerson.updatePerson(person);

    if (existingSport.getId() != existingPerson.getSport().getId()) {
      Membership membership = membershipRepository.findOne(existingPerson.getMemberships().get(0).getId());
      membership.setEndDate(new Date());
      membershipRepository.save(membership);
    }

    personRepository.save(existingPerson);
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
      membershipRepository.save(membership);
    }

  }
}
