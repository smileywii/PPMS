package ppms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ppms.dto.NewSportDTO;
import ppms.dto.UpdateSportDTO;
import ppms.service.SportService;

@Controller
@RequestMapping("/sport")
public class SportController {

  @Autowired
  SportService sportService;

  @RequestMapping()
  public String sport(Model model) {
    model.addAttribute("sports", sportService.findAll());

    model.addAttribute("newSportDTO", new NewSportDTO());
    model.addAttribute("updateSportDTO", new UpdateSportDTO());

    return "sport/sport";
  }

  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String newSport(@Valid NewSportDTO sportDTO, BindingResult sportDTOBinding) {

    if (isNoObjectBindingError(sportDTOBinding)) {
      sportService.save(sportDTO);
    }

    return "redirect:/sport";
  }

  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public String newSport(@Valid UpdateSportDTO sportDTO, BindingResult sportDTOBinding) {

    if (isNoObjectBindingError(sportDTOBinding)) {
      sportService.update(sportDTO);
    }

    return "redirect:/sport";
  }

  @RequestMapping("/delete/{id}")
  public String delete(@PathVariable Long id) {
    sportService.delete(id);
    return "redirect:/sport";
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
