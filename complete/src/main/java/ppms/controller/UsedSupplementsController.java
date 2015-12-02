package ppms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ppms.domain.Person;
import ppms.dto.NewUsedSuppDTO;
import ppms.dto.UpdateUsedSuppDTO;
import ppms.service.PersonService;
import ppms.service.UsedSupplementsService;

@Controller
@RequestMapping("/usedSupp")
public class UsedSupplementsController {

  @Autowired
  PersonService personService;

  @Autowired
  UsedSupplementsService usedSupplementService;

  // TODO: exception if not 0
  @RequestMapping(value = "/new/{id}", method = RequestMethod.POST)
  public String newSupplement(@PathVariable Long id, @Valid NewUsedSuppDTO suppDTO, BindingResult suppDTOBinding) {
    Person person = null;
    if (isNoObjectBindingError(suppDTOBinding) && idIsPositive(id)) {
      person = personService.findOne(id);
      usedSupplementService.addSupplementToPerson(suppDTO, person);
    }

    return "redirect:/person/show/" + person.getId();
  }

  // TODO: show
  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public String update(@Valid UpdateUsedSuppDTO usedSuppDTO, BindingResult usedSuppDTOBinding) {
    if (isNoObjectBindingError(usedSuppDTOBinding)) {
      usedSupplementService.update(usedSuppDTO);
    }

    return "redirect:/person/";
  }

  // TODO: show
  @RequestMapping("/delete/{id}")
  public String deleteSupplement(@PathVariable Long id) {
    usedSupplementService.delete(id);
    return "redirect:/person/";
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

  private boolean idIsPositive(long... ids) {
    for (long id : ids) {
      if (id < 0)
        return false;
    }
    return true;
  }

}
