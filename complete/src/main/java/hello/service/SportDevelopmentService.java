package hello.service;

import hello.repository.SportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportDevelopmentService {

  @Autowired
  SportRepository sportRepository;

}
