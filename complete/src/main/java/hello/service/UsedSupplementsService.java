package hello.service;

import hello.repository.UsedSupplementsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsedSupplementsService {

  @Autowired
  UsedSupplementsRepository usedSupplementsRepository;

}
