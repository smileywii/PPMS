package ppms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ppms.repository.TrainingMethodRepository;

@Service
public class TrainingMethodService {

  @Autowired
  TrainingMethodRepository trainingMethodRepository;

}
