package ppms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ppms.repository.SportRepository;

@Service
public class SportDevelopmentService {

  @Autowired
  SportRepository sportRepository;

}
