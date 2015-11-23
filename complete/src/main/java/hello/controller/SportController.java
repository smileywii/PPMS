package hello.controller;

import hello.domain.Sport;
import hello.repository.SportRepository;

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
@RequestMapping("/sport")
public class SportController {

  @Autowired
  SportRepository sportRepository;

  @RequestMapping()
  public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
      Sport sport, Model model) {
    model.addAttribute("sports", sportRepository.findAll());
    return "sport/sport";
  }

  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String newPerson(@Valid Sport sport, BindingResult bindingResult, Model model) {
    System.out.println(sport.getName());
    System.out.println(bindingResult.getErrorCount());
    System.out.println(bindingResult.getFieldError());

    if (bindingResult.getErrorCount() == 0) {
      sportRepository.save(sport);
    }

    return "redirect:/sport";
  }

  @RequestMapping("/delete/{id}")
  public String delete(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
      Model model, @PathVariable Long id) {
    sportRepository.delete(id);
    return "redirect:/sport";
  }
}
