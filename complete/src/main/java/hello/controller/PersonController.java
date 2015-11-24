package hello.controller;

import hello.domain.Club;
import hello.domain.DateHolder;
import hello.domain.IdHolder;
import hello.domain.Membership;
import hello.domain.Person;
import hello.domain.Result;
import hello.service.ClubService;
import hello.service.EventService;
import hello.service.MembershipService;
import hello.service.PersonService;
import hello.service.SportService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/person")
public class PersonController {

  @Autowired
  PersonService personService;

  @Autowired
  EventService eventService;

  @Autowired
  ClubService clubService;

  @Autowired
  MembershipService memberListService;

  @Autowired
  SportService sportService;

  @RequestMapping("/index")
  public String index() {
    return "index";
  }

  @RequestMapping("/chart")
  public String chart() {
    return "person/chart";
  }

  @RequestMapping()
  public String tables(String name, Model model, Person person) {
    model.addAttribute("person", new Person());
    model.addAttribute("personId", new IdHolder());
    model.addAttribute("sportId", new IdHolder());
    model.addAttribute("allperson", personService.findAll());
    model.addAttribute("clubId", new IdHolder());
    model.addAttribute("allSport", sportService.findAll());
    model.addAttribute("allClub", clubService.findAll());
    return "person/person";
  }

  @RequestMapping("/show/{id}")
  public String show(String name, Result result, Model model, @PathVariable Long id) {
    Person person = personService.findOne(id);
    model.addAttribute("person", person);

    model.addAttribute("result", new Result());
    model.addAttribute("memberList", new Membership());
    model.addAttribute("club", new Club());
    model.addAttribute("dateholder", new DateHolder());
    model.addAttribute("idholder", new IdHolder());

    model.addAttribute("results", person.getResults());
    model.addAttribute("sportdevs", person.getSportDevelopmentList());
    model.addAttribute("physicaldevs", person.getPhysicalDevelopmentList());
    model.addAttribute("trainingmethods", person.getTrainingMethod());
    model.addAttribute("usedsupps", person.getUsedSupplementsList());
    model.addAttribute("number", person.getMemberships().size());
    model.addAttribute("memberships", person.getMemberships());
    model.addAttribute("allClub", clubService.findAll());

    return "person/show";
  }

  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String newPerson(@Valid Person person, BindingResult personBinding, Model model, @Valid IdHolder clubId,
      BindingResult clubIdBinding) {
    if (isNoObjectBindingError(personBinding, clubIdBinding) && idIsPositive(clubId.getId())) {
      personService.registerPerson(person, clubId.getId());
    }

    return "redirect:/person";
  }

  @RequestMapping(value = "/newResult", method = RequestMethod.POST)
  public String newResult(@Valid Result result, BindingResult bindingResult, Model model) {

    if (bindingResult.getErrorCount() == 0) {
      // .save(person);
    }

    return "redirect:/person";
  }

  @RequestMapping(value = "/{id}/newclub", method = RequestMethod.POST)
  public String newClub(@PathVariable Long id, @Valid DateHolder dateHolder, BindingResult dateBinding,
      @Valid IdHolder idHolder, BindingResult idBinding, Model model) {

    if (isNoObjectBindingError(dateBinding, idBinding) && idIsPositive(id, idHolder.getId())) {
      personService.newClub(id, dateHolder, idHolder.getId());
    }

    return "redirect:/person";
  }

  @RequestMapping("/delete/{id}")
  public String delete(Model model, @PathVariable Long id) {
    personService.delete(id);
    return "redirect:/person";
  }

  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public String update(Model model, @Valid Person person, BindingResult personBinding, @Valid IdHolder personId,
      BindingResult personIdBinding, @Valid IdHolder sportId, BindingResult sportIdBinding) {
    if (isNoObjectBindingError(personBinding) && idIsPositive(sportId.getId(), sportId.getSecondaryId())) {
      personService.update(person, sportId.getSecondaryId(), sportId.getId());
    }
    return "redirect:/person";
  }

  private boolean isNoObjectBindingError(BindingResult... bindingResult) {
    for (BindingResult result : bindingResult) {
      if (result.getErrorCount() != 0)
        return false;
    }
    return true;
  }

  private boolean idIsPositive(long... ids) {
    for (long id : ids) {
      if (id < 0)
        return false;
    }
    return true;
  }
}
