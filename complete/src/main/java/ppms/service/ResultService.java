package ppms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ppms.domain.Result;
import ppms.repository.ResultRepository;

@Service
public class ResultService {

  @Autowired
  ResultRepository resultsRepository;

  public List<Result> findAllByEventId(Long id) {
    return resultsRepository.findAllByEventId(id);
  }

}
