package ppms.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ppms.domain.Club;
import ppms.domain.Membership;
import ppms.domain.Person;
import ppms.repository.ClubRepository;
import ppms.repository.MembershipRepository;
import ppms.service.PersonService;

@Controller
public class MembershipController {

  @Autowired
  MembershipRepository repository;
  @Autowired
  ClubRepository crepository;
  @Autowired
  PersonService prepository;

  @RequestMapping("/memberlist")
  public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
      Model model) {

    // Club club = new Club("Ferrari");
    // crepository.save(club);
    //
    // Person member = new Person("Schumacher", 46, "Hurth");
    // Person member2 = new Person("Vettel", 50, "Berlin");
    //
    // prepository.save(member);
    // prepository.save(member2);
    //
    // List<Person> list = new ArrayList<>();
    // list.add(member2);
    // list.add(member);
    // MemberList ms = new MemberList(club, list);
    // repository.save(ms);
    //
    // List<Person> pl = (List<Person>) prepository.findAll();
    // Person p = pl.get(0);
    // p.setMembership(ms);
    // prepository.save(p);

    Club club = new Club("Ferrari", "Italy");
    crepository.save(club);

    Person member = new Person("Schumacher", new Date(1990), "Hurth");
    Person member2 = new Person("Vettel", new Date(1990), "Berlin");

    prepository.save(member);
    prepository.save(member2);

    List<Person> list = new ArrayList<>();
    list.add(member2);
    list.add(member);

    Membership ms = new Membership(club, member, new Date(1990), new Date(2000));
    repository.save(ms);

    List<Person> pl = (List<Person>) prepository.findAll();
    Person p = pl.get(0);
    prepository.save(p);

    model.addAttribute("name", prepository.count());// repository.findAll().iterator().next());
    return "sport";
  }
}
