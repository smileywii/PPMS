package ppms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ppms.repository.PhysicalDevelopmentRepository;

@Service
public class PhysicalDevelopmentService {

  @Autowired
  PhysicalDevelopmentRepository physicalDevelopmentRepository;

}
