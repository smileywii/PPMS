package hello.controller;

import hello.domain.Person;
import hello.service.PersonService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/person")
public class PersonController {

  @Autowired
  PersonService personRepository;

  @RequestMapping("/index")
  public String index() {
    return "index";
  }

  @RequestMapping()
  public String tables(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
      Model model, Person person) {
    model.addAttribute("allperson", personRepository.findAll());
    return "person/person";
  }

  @RequestMapping("/alma")
  public String alma(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
    model.addAttribute("name", personRepository.findAll().get(0).getName());
    model.addAttribute("name1", personRepository.findAll().size());
    model.addAttribute("name2", personRepository.findAll().get(0).getResults().get(0).getSport().getName());
    model.addAttribute("dev1", personRepository.findAll().get(0).getPhysicalDevelopmentList().get(0).getWeight());
    model.addAttribute("dev2", personRepository.findAll().get(0).getPhysicalDevelopmentList().get(1).getWeight());
    model.addAttribute("sup", personRepository.findAll().get(0).getUsedSupplementsList().get(0).getSupplement()
        .getBrand());
    return "sport2";
  }

  @RequestMapping("/show/{id}")
  public String show( Model model,
      @PathVariable Long id) {
    Person person = personRepository.findOne(id);
    model.addAttribute("person", person);

    model.addAttribute("results", person.getResults());
    model.addAttribute("event", person.getResults());
    model.addAttribute("sportdevs", person.getSportDevelopmentList());
    model.addAttribute("physicaldevs", person.getPhysicalDevelopmentList());
    model.addAttribute("trainingmethods", person.getTrainingMethod());
    model.addAttribute("usedsupps", person.getUsedSupplementsList());
    model.addAttribute("number", person.getMemberships().size());
    model.addAttribute("memberships", person.getMemberships());

    return "person/show";
  }

  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String newPerson(@Valid Person person, BindingResult bindingResult, Model model) {
    System.out.println(person.getName());
    System.out.println(bindingResult.getErrorCount());
    System.out.println(bindingResult.getFieldError());

    if (bindingResult.getErrorCount() == 0) {
      personRepository.save(person);
    }

    return "redirect:/person";
  }

  @RequestMapping("/delete/{id}")
  public String delete(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
      Model model, @PathVariable Long id) {
    personRepository.delete(id);
    return "redirect:/person";
  }
}
