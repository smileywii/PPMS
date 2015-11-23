package hello.service;

import hello.domain.MemberList;
import hello.repository.MemberListRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberListService {

  @Autowired
  MemberListRepository memberListRepository;

  public MemberList findOne(long id) {
    return memberListRepository.findOne(id);
  }

  public List<MemberList> findAll() {
    return memberListRepository.findAll();
  }

  public long count() {
    return memberListRepository.count();
  }

  public void delete(Long id) {
    memberListRepository.delete(id);
  }

}
