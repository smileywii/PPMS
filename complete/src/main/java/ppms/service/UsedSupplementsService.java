package ppms.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ppms.domain.NutritionalSupplement;
import ppms.domain.Person;
import ppms.domain.UsedSupplement;
import ppms.dto.NewUsedSuppDTO;
import ppms.dto.UpdateUsedSuppDTO;
import ppms.repository.UsedSupplementsRepository;

@Service
public class UsedSupplementsService {

  @Autowired
  PersonService personService;

  @Autowired
  UsedSupplementsRepository usedSupplementsRepository;

  @Autowired
  NutritionalSupplementService nutritionalSupplementService;

  public List<Person> getAllPeopleUsingThisSupplement(Long id) {
    return usedSupplementsRepository.getAllPeopleUsingThisSupplement(id);
  }

  // public List<Club> getAllClubUsingThisSupplement(Long id) {
  // List<MembershipService> club = usedSupplementsRepository.getAllClubUsingThisSupplement(id);
  // System.out.println(club.size());
  // List<Club> clubs = new ArrayList<>();
  // return clubs;
  // }

  public void save(@Valid UsedSupplement usedSupplement) {
    usedSupplementsRepository.save(usedSupplement);
  }

  public void addSupplementToPerson(NewUsedSuppDTO suppDTO, Person person) {
    NutritionalSupplement nutritionalSupplement = nutritionalSupplementService.findOne(suppDTO.getSupplementId());
    UsedSupplement usedSupplement = new UsedSupplement(suppDTO, person, nutritionalSupplement);

    save(usedSupplement);
  }

  public void delete(Long id) {
    usedSupplementsRepository.delete(id);
  }

  public void update(UpdateUsedSuppDTO usedSuppDTO) {
    UsedSupplement usedSupplement = usedSupplementsRepository.findOne(usedSuppDTO.getUsedSuppId());
    usedSupplement.update(usedSuppDTO);
    save(usedSupplement);

  }

  public List<UsedSupplement> findAll() {
    return usedSupplementsRepository.findAll();
  }

}
