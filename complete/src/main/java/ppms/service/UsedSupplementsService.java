package ppms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ppms.repository.UsedSupplementsRepository;

@Service
public class UsedSupplementsService {

  @Autowired
  UsedSupplementsRepository usedSupplementsRepository;

}
