package hello.service;

import hello.domain.Result;
import hello.repository.ResultRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultService {

  @Autowired
  ResultRepository resultsRepository;

  public List<Result> findAllByEventId(Long id) {
    return resultsRepository.findAllByEventId(id);
  }

}
