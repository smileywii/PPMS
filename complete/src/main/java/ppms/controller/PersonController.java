package ppms.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ppms.domain.Club;
import ppms.domain.DateHolder;
import ppms.domain.IdHolder;
import ppms.domain.Membership;
import ppms.domain.Person;
import ppms.domain.Result;
import ppms.dto.NewPersonDTO;
import ppms.dto.NewPhysicalDevDTO;
import ppms.dto.NewResultDTO;
import ppms.dto.NewUsedSuppDTO;
import ppms.dto.UpdatePersonDTO;
import ppms.dto.UpdatePhysicalDevDTO;
import ppms.dto.UpdateResultDTO;
import ppms.dto.UpdateUsedSuppDTO;
import ppms.service.ClubService;
import ppms.service.EventService;
import ppms.service.MembershipService;
import ppms.service.NutritionalSupplementService;
import ppms.service.PersonService;
import ppms.service.PhysicalDevelopmentService;
import ppms.service.ResultService;
import ppms.service.SportService;
import ppms.service.UsedSupplementsService;

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

  @Autowired
  ResultService resultService;

  @Autowired
  PhysicalDevelopmentService physicalDevelopmentService;

  @Autowired
  NutritionalSupplementService nutritionalSupplementService;

  @Autowired
  UsedSupplementsService usedSupplementService;

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

    model.addAttribute("newPersonDTO", new NewPersonDTO());
    model.addAttribute("updatePersonDTO", new UpdatePersonDTO());

    return "person/person";
  }

  @RequestMapping("/show/{id}")
  public String show(Model model, @PathVariable Long id) {
    Person person = personService.findOne(id);
    model.addAttribute("person", person);

    model.addAttribute("result", new Result());
    model.addAttribute("memberList", new Membership());
    model.addAttribute("club", new Club());
    model.addAttribute("dateholder", new DateHolder());
    model.addAttribute("idholder", new IdHolder());

    model.addAttribute("newResultDTO", new NewResultDTO());
    model.addAttribute("newPersonDTO", new NewPersonDTO());
    model.addAttribute("newPhysicalDevDTO", new NewPhysicalDevDTO());
    model.addAttribute("newUsedSuppDTO", new NewUsedSuppDTO());
    model.addAttribute("updatePhysicalDevDTO", new UpdatePhysicalDevDTO());
    model.addAttribute("updatePersonDTO", new UpdatePersonDTO());
    model.addAttribute("updateResultDTO", new UpdateResultDTO());
    model.addAttribute("updateUsedSuppDTO", new UpdateUsedSuppDTO());

    model.addAttribute("results", person.getResults());
    model.addAttribute("sportdevs", person.getSportDevelopmentList());
    model.addAttribute("physicaldevs", person.getPhysicalDevelopmentList());
    model.addAttribute("trainingmethods", person.getTrainingMethod());
    model.addAttribute("usedsupps", person.getUsedSupplementsList());
    model.addAttribute("number", person.getMemberships().size());
    model.addAttribute("memberships", person.getMemberships());
    model.addAttribute("allClub", clubService.findAll());
    model.addAttribute("physicaldevs", person.getPhysicalDevelopmentList());
    model.addAttribute("allPossibleEvent", eventService.allEventsBetweenDate(person.getBirthDate(), new Date()));
    model.addAttribute("allsupplements", nutritionalSupplementService.findAll());

    return "person/show";
  }

  // TODO: date for club membership
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String newPerson(@Valid NewPersonDTO personDTO, BindingResult personDTOBinding) {
    if (isNoObjectBindingError(personDTOBinding)) {
      personService.registerPerson(personDTO);
    }

    return "redirect:/person";
  }

  @RequestMapping(value = "/newResult", method = RequestMethod.POST)
  public String newResult(@Valid NewResultDTO newResultDTO, BindingResult resultDTObinding, Model model) {

    if (resultDTObinding.getErrorCount() == 0) {
      resultService.save(newResultDTO);
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
  public String delete(@PathVariable Long id) {
    personService.delete(id);
    return "redirect:/person";
  }

  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public String updatePerson(@Valid UpdatePersonDTO personDTO, BindingResult personDTOBinding) {
    if (isNoObjectBindingError(personDTOBinding)) {
      personService.update(personDTO);
    }
    return "redirect:/person";
  }

  public boolean isNoObjectBindingError(BindingResult... bindingResult) {
    for (BindingResult result : bindingResult) {
      if (result.getErrorCount() != 0) {
        System.out.println("Binding error:" + result.getFieldErrors().toString());
        return false;
      }
    }
    return true;
  }

  public boolean idIsPositive(long... ids) {
    for (long id : ids) {
      if (id < 0)
        return false;
    }
    return true;
  }
}
