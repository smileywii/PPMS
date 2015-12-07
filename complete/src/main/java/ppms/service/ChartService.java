package ppms.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ppms.domain.Person;
import ppms.domain.Result;
import ppms.domain.UsedSupplement;
import ppms.utils.Constants;

@Service
public class ChartService {

  @Autowired
  PersonService personService;

  @Autowired
  UsedSupplementsService usedSupplementsService;

  protected void setPersonService(PersonService personService) {
    this.personService = personService;
  }

  public int getClubSupplementUsageCount(long id) {
    int count = 0;
    for (Person person : usedSupplementsService.getAllPeopleUsingThisSupplement(id)) {
      if (!person.getClubNameAtDate(new Date()).equals(Constants.PERSON_HAS_NO_CLUB)) {
        count++;
      }
    }
    return count;
  }

  public List<Person> getAllPeopleUsingThisSupplement(long id) {
    return usedSupplementsService.getAllPeopleUsingThisSupplement(id);
  }

  public int getAllClubCountUsingThisSupplement(long id) {
    int count = 0;
    for (Person person : usedSupplementsService.getAllPeopleUsingThisSupplement(id)) {
      if (!person.getClubNameAtDate(new Date()).equals(Constants.PERSON_HAS_NO_CLUB)) {
        count++;
      }
    }
    return count;
  }

  public int getAllPeopleCountUsingThisBrand(String brand) {
    List<Person> people = personService.findAll();
    int count = 0;
    for (Person person : people) {
      if (isPersonUseBrand(person.getUsedSupplementsList(), brand)) {
        count++;
      }
    }
    return count;
  }

  private boolean isPersonUseBrand(List<UsedSupplement> usedSupplementlist, String brand) {
    for (UsedSupplement usedSupplement : usedSupplementlist) {
      if (usedSupplement.getSupplement().getBrand().equals(brand)) {
        return true;
      }
    }
    return false;
  }

  public Set<Integer> getPositionSetFromResults(List<Result> results) {
    Set<Integer> positions = new HashSet<Integer>();
    for (Result result : results) {
      positions.add(result.getPosition());
    }
    return positions;
  }

  public int getCountOfPositionInResults(List<Result> results, Integer position) {
    int count = 0;
    for (Result result : results) {
      if (result.getPosition() == position) {
        count++;
      }
    }
    return count;
  }
}
