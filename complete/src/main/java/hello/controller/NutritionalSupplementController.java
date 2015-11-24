package hello.controller;

import hello.domain.NutritionalSupplement;
import hello.service.NutritionalSupplementService;

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
@RequestMapping("/supplement")
public class NutritionalSupplementController {

  @Autowired
  NutritionalSupplementService nutritionalSupplementService;

  @RequestMapping()
  public String index(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
      NutritionalSupplement nuttritionalSupplement, Model model) {
    model.addAttribute("supplements", nutritionalSupplementService.findAll());
    return "supplement/supplement";
  }

  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String newSupplement(@Valid NutritionalSupplement nutritionalSupplement, BindingResult bindingResult,
      Model model) {

    if (bindingResult.getErrorCount() == 0) {
      nutritionalSupplementService.save(nutritionalSupplement);
    }

    return "redirect:/supplement";
  }

  @RequestMapping("/delete/{id}")
  public String delete(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
      Model model, @PathVariable Long id) {
    nutritionalSupplementService.delete(id);
    return "redirect:/supplement";
  }

}
