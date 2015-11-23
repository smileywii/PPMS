package hello.controller;

import hello.domain.Event;
import hello.service.EventService;
import hello.service.ResultService;

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
@RequestMapping("/event")
public class EventController {

  @Autowired
  EventService eventService;

  @Autowired
  ResultService resultService;

  @RequestMapping()
  public String tables(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
      Model model, Event event) {
    model.addAttribute("events", eventService.findAll());
    return "event/event";
  }

  @RequestMapping("/show/{id}")
  public String show(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model,
      @PathVariable Long id) {
    Event event = eventService.findOne(id);
    model.addAttribute("event", event);
    System.out.println(resultService.findAllByEventId(id).size());
    model.addAttribute("results", resultService.findAllByEventId(id));

    return "event/show";
  }

  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String newEvent(@Valid Event event, BindingResult bindingResult, Model model) {
    if (bindingResult.getErrorCount() == 0) {
      eventService.save(event);
    }

    return "redirect:/event";
  }

  @RequestMapping("/delete/{id}")
  public String delete(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
      Model model, @PathVariable Long id) {
    eventService.delete(id);
    return "redirect:/event";
  }

}
