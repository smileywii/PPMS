package hello.controller;

import hello.domain.Club;
import hello.service.ClubService;

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
@RequestMapping("/club")
public class ClubController {

  @Autowired
  ClubService clubService;

  @RequestMapping()
  public String tables( String name, Model model, Club club) {
    model.addAttribute("clubs", clubService.findAll());
    return "club/club";
  }

  @RequestMapping("/show/{id}")
  public String show( String name, Model model, @PathVariable Long id) {
    Club club = clubService.findOne(id);
    model.addAttribute("club", club);
    return "club/show";
  }

  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String newClub(@Valid Club club, BindingResult bindingResult, Model model) {
    if (bindingResult.getErrorCount() == 0) {
      clubService.save(club);
    }

    return "redirect:/club";
  }

  @RequestMapping("/delete/{id}")
  public String delete(String name,  Model model, @PathVariable Long id) {
    clubService.delete(id);
    return "redirect:/club";
  }
}
