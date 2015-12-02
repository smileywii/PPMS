package ppms.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ppms.domain.Person;
import ppms.domain.PhysicalDevelopment;
import ppms.dto.NewPhysicalDevDTO;
import ppms.dto.UpdatePhysicalDevDTO;
import ppms.repository.PhysicalDevelopmentRepository;

@Service
public class PhysicalDevelopmentService {

  @Autowired
  PhysicalDevelopmentRepository physicalDevelopmentRepository;

  @Autowired
  SportService sportService;

  @Autowired
  PersonService personService;

  public void save(NewPhysicalDevDTO devDTO) {
    Person person = personService.findOne(devDTO.getPersonId());
    PhysicalDevelopment physicalDevelopment = new PhysicalDevelopment(devDTO, person);

    save(physicalDevelopment);
  }

  public long getPersonIdByPhysicalDevId(Long id) {
    return physicalDevelopmentRepository.findOne(id).getPerson().getId();
  }

  public void update(UpdatePhysicalDevDTO devDTO) {
    PhysicalDevelopment physicalDevelopment = physicalDevelopmentRepository.findOne(devDTO.getDevelopmentId());
    physicalDevelopment.update(devDTO);

    save(physicalDevelopment);
  }

  public void delete(Long id) {
    physicalDevelopmentRepository.delete(id);

  }

  private void save(@Valid PhysicalDevelopment physicalDevelopment) {
    physicalDevelopmentRepository.save(physicalDevelopment);
  }

}
