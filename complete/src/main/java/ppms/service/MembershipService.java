package ppms.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ppms.domain.Membership;
import ppms.domain.Person;
import ppms.repository.MembershipRepository;

@Service
public class MembershipService {

  @Autowired
  MembershipRepository membershipRepository;

  public Membership findOne(long id) {
    return membershipRepository.findOne(id);
  }

  public List<Membership> findAll() {
    return membershipRepository.findAll();
  }

  public long count() {
    return membershipRepository.count();
  }

  public void delete(Long id) {
    membershipRepository.delete(id);
  }

  public void save(@Valid Membership membership) {
    membershipRepository.save(membership);

  }

  public List<Person> getAllMembersOfClub(Long id) {
    return membershipRepository.getAllMembersOfClub(id);
  }

  public List<Membership> getAllMembershipOfClub(Long id) {
    return membershipRepository.getAllMembershipOfClub(id);
  }
}
