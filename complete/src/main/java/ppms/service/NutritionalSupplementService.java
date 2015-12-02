package ppms.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ppms.domain.NutritionalSupplement;
import ppms.dto.NewSupplementDTO;
import ppms.dto.UpdateSupplementDTO;
import ppms.repository.NutritionalSupplementRepository;

@Service
public class NutritionalSupplementService {

  @Autowired
  NutritionalSupplementRepository nutritionalSupplementRepository;

  @Autowired
  UsedSupplementsService usedSupplementsService;

  public NutritionalSupplement findOne(long id) {
    return nutritionalSupplementRepository.findOne(id);
  }

  public List<NutritionalSupplement> findAll() {
    return nutritionalSupplementRepository.findAll();
  }

  public void save(@Valid NutritionalSupplement sport) {
    nutritionalSupplementRepository.save(sport);
  }

  public long count() {
    return nutritionalSupplementRepository.count();
  }

  // TODO: exception when not 0
  public void delete(Long id) {
    if (usedSupplementsService.getAllPeopleUsingThisSupplement(id).size() == 0) {
      nutritionalSupplementRepository.delete(id);
    }
  }

  public void save(NewSupplementDTO supplementDTO) {
    save(new NutritionalSupplement(supplementDTO));

  }

  public void update(UpdateSupplementDTO supplementDTO) {
    NutritionalSupplement nutritionalSupplement = nutritionalSupplementRepository.findOne(supplementDTO
        .getSupplementId());
    nutritionalSupplement.update(supplementDTO);

    save(nutritionalSupplement);
  }

}
