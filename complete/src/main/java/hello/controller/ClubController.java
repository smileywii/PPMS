package hello.controller;

import hello.domain.Club;
import hello.domain.IdHolder;
import hello.domain.Sport;
import hello.service.ClubService;
import hello.service.MembershipService;
import hello.service.SportService;

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

  @Autowired
  MembershipService memberListService;

  @Autowired
  SportService sportService;

  @RequestMapping()
  public String tables(String name, Model model, Club club) {
    model.addAttribute("sportId", new IdHolder());
    model.addAttribute("allSport", sportService.findAll());
    model.addAttribute("clubs", clubService.findAll());

    return "club/club";
  }

  @RequestMapping("/show/{id}")
  public String show(String name, Model model, @PathVariable Long id) {
    Club club = clubService.findOne(id);
    model.addAttribute("club", club);
    // TODO
    // model.addAttribute("members", memberListService.fi.get());

    return "club/show";
  }

  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String newClub(@Valid Club club, BindingResult clubBinding, @Valid IdHolder sportId,
      BindingResult sportBinding, Model model) {

    if (clubBinding.getErrorCount() == 0 && clubBinding.getErrorCount() == 0) {
      Sport sport = sportService.findOne(sportId.getId());
      club.setSport(sport);
      clubService.save(club);
    }

    return "redirect:/club";
  }

  @RequestMapping("/delete/{id}")
  public String delete(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
      Model model, @PathVariable Long id) {
    clubService.delete(id);
    return "redirect:/club";
  }
}
