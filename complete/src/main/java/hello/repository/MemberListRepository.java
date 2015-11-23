package hello.repository;

import hello.domain.MemberList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberListRepository extends JpaRepository<MemberList, Long> {

}
