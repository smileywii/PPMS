package ppms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ppms.dto.NewPhysicalDevDTO;
import ppms.dto.UpdatePhysicalDevDTO;
import ppms.service.PhysicalDevelopmentService;

@Controller
@RequestMapping("/physicalDevelopment")
public class PhysicalDevelopmentController {

  @Autowired
  PhysicalDevelopmentService physicalDevelopmentService;

  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String newDev(@Valid NewPhysicalDevDTO devDTO, BindingResult devDTOBinding) {

    if (isNoObjectBindingError(devDTOBinding)) {
      physicalDevelopmentService.save(devDTO);
    }

    return "redirect:/person/show/" + devDTO.getPersonId();
  }

  @RequestMapping(value = "/delete/{id}")
  public String deleteDev(@PathVariable Long id) {
    Long personId = physicalDevelopmentService.getPersonIdByPhysicalDevId(id);
    physicalDevelopmentService.delete(id);

    return "redirect:/person/show/" + personId;
  }

  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public String updateDev(@Valid UpdatePhysicalDevDTO devDTO, BindingResult devDTOBinding) {
    Long personId = physicalDevelopmentService.getPersonIdByPhysicalDevId(devDTO.getDevelopmentId());
    if (isNoObjectBindingError(devDTOBinding)) {
      physicalDevelopmentService.update(devDTO);
    }
    return "redirect:/person/show/" + personId;
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
