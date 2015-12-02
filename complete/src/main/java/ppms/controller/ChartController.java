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
import ppms.domain.UsedSupplement;
import ppms.service.NutritionalSupplementService;
import ppms.service.PersonService;
import ppms.service.SportService;
import ppms.service.UsedSupplementsService;

@Controller
@RequestMapping("/chart")
public class ChartController {

  @Autowired
  SportService sportService;

  @Autowired
  PersonService personService;

  @Autowired
  UsedSupplementsService usedSupplementsService;

  @Autowired
  NutritionalSupplementService nutritionalSupplementService;

  @RequestMapping("/sportsPopularity")
  public String sportsPopularity() {
    return "/chart/sportsPopularity";
  }

  @RequestMapping("/supplementsPopularity")
  public String supplementsPopularity() {
    return "/chart/supplementsPopularity";
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
    System.out.println(sports.size());
    for (Sport sport : sports) {
      try {

        JSONArray jsonArray = new JSONArray().put(new JSONObject().put("name", sport.getName()).put("number",
            personService.numberOfClubDoingSport(sport.getId())));

        json.put(i.toString(), jsonArray);
        i++;
      } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
    return json.toString();
  }

  @RequestMapping(value = "supplementpopularity", method = RequestMethod.GET)
  public @ResponseBody String getNutritionalSupplementPopularity() {

    JSONObject json = new JSONObject();
    Integer i = 0;
    List<UsedSupplement> usedSupplements = usedSupplementsService.findAll();
    for (UsedSupplement usedSupplement : usedSupplements) {
      try {

        JSONArray jsonArray = new JSONArray().put(new JSONObject().put(
            "name",
            usedSupplement.getSupplement().getName() + " - " + usedSupplement.getSupplement().getQuantity()
                + usedSupplement.getSupplement().getUnit()).put("number",
            usedSupplementsService.getAllPeopleUsingThisSupplement(usedSupplement.getSupplement().getId()).size()));
        json.put(i.toString(), jsonArray);
        i++;
        System.out.println(jsonArray);
      } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
    return json.toString();
  }

  // @RequestMapping(value = "supplementpopularityByClub", method = RequestMethod.GET)
  // public @ResponseBody String getNutritionalSupplementPopularityByClub() {
  //
  // JSONObject json = new JSONObject();
  // Integer i = 0;
  // List<UsedSupplement> usedSupplements = usedSupplementsService.findAll();
  // for (UsedSupplement usedSupplement : usedSupplements) {
  // try {
  //
  // JSONArray jsonArray = new JSONArray().put(new JSONObject().put(
  // "name",
  // usedSupplement.getSupplement().getName() + " - " + usedSupplement.getSupplement().getQuantity()
  // + usedSupplement.getSupplement().getUnit()).put("number",
  // usedSupplementsService.getAllClubUsingThisSupplement(usedSupplement.getSupplement().getId()).size()));
  // json.put(i.toString(), jsonArray);
  // i++;
  // System.out.println(jsonArray);
  // } catch (JSONException e) {
  // // TODO Auto-generated catch block
  // e.printStackTrace();
  // }
  //
  // }
  // return json.toString();
  // }
}
