package hello.service;

import hello.repository.TrainingMethodRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingMethodService {

  @Autowired
  TrainingMethodRepository trainingMethodRepository;

}
