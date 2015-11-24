package ppms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ppms.domain.Membership;
import ppms.repository.MembershipRepository;

@Service
public class MembershipService {

  @Autowired
  MembershipRepository memberListRepository;

  public Membership findOne(long id) {
    return memberListRepository.findOne(id);
  }

  public List<Membership> findAll() {
    return memberListRepository.findAll();
  }

  public long count() {
    return memberListRepository.count();
  }

  public void delete(Long id) {
    memberListRepository.delete(id);
  }

  public void save(Membership memberList) {
    memberListRepository.save(memberList);

  }
}
