package ppms.controller;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ppms.domain.Sport;
import ppms.service.PersonService;
import ppms.service.SportService;

@Controller
@RequestMapping("/chart")
public class ChartController {

  @Autowired
  SportService sportService;

  @Autowired
  PersonService personService;

  @RequestMapping
  public String index() {
    return "chart/chart";
  }

  @RequestMapping(value = "sportpopularitybypeople", method = RequestMethod.GET)
  public @ResponseBody String getSportPopularity() {

    JSONObject json = new JSONObject();
    Integer i = 0;
    List<Sport> sports = sportService.findAll();
    for (Sport sport : sports) {
      try {
        JSONArray jsonArray = new JSONArray().put(new JSONObject().put("name", sport.getName()).put("number",
            personService.numberOfPeopleDoingSport(sport.getId())));
        json.put(i.toString(), jsonArray);
        i++;
      } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
    return json.toString();
  }

  @RequestMapping(value = "sportpopularitybyclub", method = RequestMethod.GET)
  public @ResponseBody String getSportPopularityByClub() {

    JSONObject json = new JSONObject();
    Integer i = 0;
    List<Sport> sports = sportService.findAll();
    for (Sport sport : sports) {
      try {

        JSONArray alma = new JSONArray().put(new JSONObject().put("name", sport.getName()).put("number",
            personService.numberOfClubDoingSport(sport.getId())));

        json.put(i.toString(), alma);
        i++;
      } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
    return json.toString();
  }

}
