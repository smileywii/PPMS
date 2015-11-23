package hello.service;

import hello.domain.Person;
import hello.repository.PersonRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

  @Autowired
  PersonRepository personRepository;

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

}
