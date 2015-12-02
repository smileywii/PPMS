package ppms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ppms.domain.Event;
import ppms.dto.NewEventDTO;
import ppms.dto.UpdateEventDTO;
import ppms.service.EventService;
import ppms.service.ResultService;

@Controller
@RequestMapping("/event")
public class EventController {

  @Autowired
  EventService eventService;

  @Autowired
  ResultService resultService;

  @RequestMapping()
  public String event(Model model) {
    model.addAttribute("events", eventService.findAll());

    model.addAttribute("newEventDTO", new NewEventDTO());
    model.addAttribute("updateEventDTO", new UpdateEventDTO());

    return "event/event";
  }

  @RequestMapping("/show/{id}")
  public String show(Model model, @PathVariable Long id) {
    Event event = eventService.findOne(id);
    model.addAttribute("event", event);
    model.addAttribute("results", resultService.findAllByEventId(id));

    return "event/show";
  }

  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String newEvent(@Valid NewEventDTO eventDTO, BindingResult eventDTOBinding) {
    if (isNoObjectBindingError(eventDTOBinding)) {
      eventService.save(eventDTO);
    }

    return "redirect:/event";
  }

  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public String updateEvent(@Valid UpdateEventDTO eventDTO, BindingResult eventDTOBinding) {
    if (isNoObjectBindingError(eventDTOBinding)) {
      eventService.update(eventDTO);
    }

    return "redirect:/event";
  }

  @RequestMapping("/delete/{id}")
  public String delete(@PathVariable Long id) {
    eventService.delete(id);
    return "redirect:/event";
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
