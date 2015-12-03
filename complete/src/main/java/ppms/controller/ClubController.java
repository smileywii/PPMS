package ppms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ppms.domain.Club;
import ppms.dto.NewClubDTO;
import ppms.dto.UpdateClubDTO;
import ppms.service.ClubService;
import ppms.service.MembershipService;
import ppms.service.SportService;

@Controller
@RequestMapping("/club")
public class ClubController {

  @Autowired
  ClubService clubService;

  @Autowired
  MembershipService membershipService;

  @Autowired
  SportService sportService;

  @RequestMapping()
  public String tables(String name, Model model, Club club) {
    model.addAttribute("allSport", sportService.findAll());
    model.addAttribute("clubs", clubService.findAll());

    model.addAttribute("newClubDTO", new NewClubDTO());
    model.addAttribute("updateClubDTO", new UpdateClubDTO());

    return "club/club";
  }

  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String newClub(@Valid NewClubDTO clubDTO, BindingResult clubDTOBinding) {

    if (isNoObjectBindingError(clubDTOBinding)) {
      clubService.save(clubDTO);
    }

    return "redirect:/club";
  }

  @RequestMapping("/show/{id}")
  public String show(String name, Model model, @PathVariable Long id) {
    Club club = clubService.findOne(id);
    model.addAttribute("club", club);
    model.addAttribute("members", membershipService.getAllMembershipOfClub(id));
    // TODO
    // model.addAttribute("members", memberListService.fi.get());

    return "club/show";
  }

  @RequestMapping("/delete/{id}")
  public String delete(@PathVariable Long id) {
    clubService.delete(id);
    return "redirect:/club";
  }

  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public String update(@Valid UpdateClubDTO clubDTO, BindingResult clubDTOBinding) {

    if (isNoObjectBindingError(clubDTOBinding)) {
      clubService.update(clubDTO);
    }

    return "redirect:/club";
  }

  private boolean isNoObjectBindingError(BindingResult... bindingResult) {
    for (BindingResult result : bindingResult) {
      if (result.getErrorCount() != 0) {
        System.out.println("Binding error:" + result.getFieldErrors().toString());
        return false;
      }
    }
    return true;
  }

}
