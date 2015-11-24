package ppms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ppms.domain.NutritionalSupplement;
import ppms.repository.NutritionalSupplementRepository;

@Service
public class NutritionalSupplementService {

  @Autowired
  NutritionalSupplementRepository nutritionalSupplementRepository;

  public NutritionalSupplement findOne(long id) {
    return nutritionalSupplementRepository.findOne(id);
  }

  public List<NutritionalSupplement> findAll() {
    return nutritionalSupplementRepository.findAll();
  }

  public void save(NutritionalSupplement sport) {
    nutritionalSupplementRepository.save(sport);
  }

  public long count() {
    return nutritionalSupplementRepository.count();
  }

  public void delete(Long id) {
    nutritionalSupplementRepository.delete(id);
  }

}
