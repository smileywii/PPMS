package hello.service;

import hello.repository.PhysicalDevelopmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhysicalDevelopmentService {

  @Autowired
  PhysicalDevelopmentRepository physicalDevelopmentRepository;

}
