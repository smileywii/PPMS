package ppms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ppms.dto.NewSupplementDTO;
import ppms.dto.UpdateSupplementDTO;
import ppms.service.NutritionalSupplementService;

@Controller
@RequestMapping("/supplement")
public class NutritionalSupplementController {

  @Autowired
  NutritionalSupplementService nutritionalSupplementService;

  @RequestMapping()
  public String supplement(Model model) {
    model.addAttribute("supplements", nutritionalSupplementService.findAll());

    model.addAttribute("newSupplementDTO", new NewSupplementDTO());
    model.addAttribute("updateSupplementDTO", new UpdateSupplementDTO());

    return "supplement/supplement";
  }

  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String newSupplement(@Valid NewSupplementDTO supplementDTO, BindingResult supplementDTOBinding) {

    if (isNoObjectBindingError(supplementDTOBinding)) {
      nutritionalSupplementService.save(supplementDTO);
    }

    return "redirect:/supplement";
  }

  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public String update(@Valid UpdateSupplementDTO supplementDTO, BindingResult supplementDTOBinding) {

    if (isNoObjectBindingError(supplementDTOBinding)) {
      nutritionalSupplementService.update(supplementDTO);
    }

    return "redirect:/supplement";
  }

  @RequestMapping("/delete/{id}")
  public String delete(@PathVariable Long id) {
    nutritionalSupplementService.delete(id);
    return "redirect:/supplement";
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
