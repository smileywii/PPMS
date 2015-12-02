package ppms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ppms.dto.UpdateResultDTO;
import ppms.service.ClubService;
import ppms.service.EventService;
import ppms.service.MembershipService;
import ppms.service.PersonService;
import ppms.service.ResultService;
import ppms.service.SportService;

@Controller
@RequestMapping("/result")
public class ResultController {

  @Autowired
  PersonService personService;

  @Autowired
  EventService eventService;

  @Autowired
  ClubService clubService;

  @Autowired
  MembershipService memberListService;

  @Autowired
  SportService sportService;

  @Autowired
  ResultService resultService;

  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public String update(UpdateResultDTO resultDTO, BindingResult resultDTOBinding) {
    resultService.update(resultDTO);

    return "redirect:/person/show/" + resultService.getPersonIdByResultId(resultDTO.getResultId());
  }

  @RequestMapping("/delete/{id}")
  public String delete(@PathVariable Long id) {
    long personId = resultService.getPersonIdByResultId(id);
    resultService.delete(id);

    return "redirect:/person/show/" + personId;
  }
}
