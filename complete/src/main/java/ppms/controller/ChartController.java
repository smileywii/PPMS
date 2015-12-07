package ppms.controller;

import java.util.List;
import java.util.Set;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ppms.domain.NutritionalSupplement;
import ppms.domain.Result;
import ppms.domain.Sport;
import ppms.service.ChartService;
import ppms.service.ClubService;
import ppms.service.NutritionalSupplementService;
import ppms.service.PersonService;
import ppms.service.ResultService;
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

  @Autowired
  ChartService chartService;

  @Autowired
  ResultService resultService;

  @Autowired
  ClubService clubService;

  @RequestMapping("/sportsPopularity")
  public String sportsPopularity() {
    return "/chart/sportsPopularity";
  }

  @RequestMapping("/supplementsPopularity")
  public String supplementsPopularity() {
    return "/chart/supplementsPopularity";
  }

  @RequestMapping("/result")
  public String results(Model model) {
    model.addAttribute("allSport", sportService.findAll());
    model.addAttribute("allClub", clubService.findAll());
    return "/chart/results";
  }

  @RequestMapping(value = "sportpopularitybypeople", method = RequestMethod.GET)
  public @ResponseBody String getSportPopularity() {

    JSONObject json = new JSONObject();
    Integer i = 0;
    List<Sport> sports = sportService.findAll();
    for (Sport sport : sports) {
      try {
        JSONArray jsonArray = new JSONArray().put(new JSONObject().put("name", sport.getName()).put("count",
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

        JSONArray jsonArray = new JSONArray().put(new JSONObject().put("name", sport.getName()).put("count",
            personService.getAllClubCountDoingSport(sport.getId())));

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
    List<NutritionalSupplement> nutritionalSupplements = nutritionalSupplementService.findAll();
    for (NutritionalSupplement nutritionalSupplement : nutritionalSupplements) {
      try {

        JSONArray jsonArray = new JSONArray().put(new JSONObject().put(
            "name",
            nutritionalSupplement.getName() + " - " + nutritionalSupplement.getQuantity()
                + nutritionalSupplement.getUnit()).put("count",
            chartService.getAllPeopleUsingThisSupplement(nutritionalSupplement.getId()).size()));
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

  @RequestMapping(value = "supplementpopularitybyclub", method = RequestMethod.GET)
  public @ResponseBody String getNutritionalSupplementPopularityByClub() {

    JSONObject json = new JSONObject();
    Integer i = 0;
    List<NutritionalSupplement> nutritionalSupplements = nutritionalSupplementService.findAll();
    for (NutritionalSupplement nutritionalSupplement : nutritionalSupplements) {
      try {

        JSONArray jsonArray = new JSONArray().put(new JSONObject().put(
            "name",
            nutritionalSupplement.getName() + " - " + nutritionalSupplement.getQuantity()
                + nutritionalSupplement.getUnit()).put("count",
            chartService.getAllClubCountUsingThisSupplement(nutritionalSupplement.getId())));
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

  @RequestMapping(value = "supplementbrandpopularitybypeople", method = RequestMethod.GET)
  public @ResponseBody String getNutritionalSupplementBrandPopularityByPeople() {

    JSONObject json = new JSONObject();
    Integer i = 0;
    Set<String> brands = nutritionalSupplementService.findAllBrand();
    for (String brand : brands) {
      try {

        JSONArray jsonArray = new JSONArray().put(new JSONObject().put("name", brand).put("count",
            chartService.getAllPeopleCountUsingThisBrand(brand)));
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

  @RequestMapping(value = "sportpopularitybypeoplefiltered", method = RequestMethod.PUT)
  public @ResponseBody String getSportPopularityFiltered(@RequestBody String filter) {
    System.out.println("+++++++++++++++++++++" + filter.toString());

    JSONObject json = new JSONObject();
    Integer i = 0;
    List<Sport> sports = sportService.findAll();
    for (Sport sport : sports) {
      try {
        JSONArray jsonArray = new JSONArray().put(new JSONObject().put("name", sport.getName()).put("count",
            personService.numberOfPeopleDoingSportAtAge(sport.getId(), filter)));
        json.put(i.toString(), jsonArray);
        i++;
      } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
    return json.toString();
  }

  @RequestMapping(value = "resultsbysport", method = RequestMethod.PUT)
  public @ResponseBody String resultsBySport(@RequestBody String sportId) {
    System.out.println(sportId);
    sportId = sportId.replace("\"", "");
    JSONObject json = new JSONObject();
    Integer i = 0;
    List<Result> results = resultService.getAllResultBySport(Long.parseLong(sportId.trim()));
    for (Integer position : chartService.getPositionSetFromResults(results)) {
      try {
        JSONArray jsonArray = new JSONArray().put(new JSONObject().put("name", position).put("count",
            chartService.getCountOfPositionInResults(results, position)));
        json.put(i.toString(), jsonArray);
        i++;
      } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
    return json.toString();
  }

  @RequestMapping(value = "resultsbyclub", method = RequestMethod.PUT)
  public @ResponseBody String resultsByClub(@RequestBody String clubId) {
    System.out.println(clubId);
    clubId = clubId.replace("\"", "");
    JSONObject json = new JSONObject();
    Integer i = 0;
    List<Result> results = resultService.getAllResultByClub(Long.parseLong(clubId.trim()));
    for (Integer position : chartService.getPositionSetFromResults(results)) {
      try {
        JSONArray jsonArray = new JSONArray().put(new JSONObject().put("name", position).put("count",
            chartService.getCountOfPositionInResults(results, position)));
        json.put(i.toString(), jsonArray);
        i++;
      } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
    return json.toString();
  }

  // @RequestMapping(value = "supplementmanufacturerpopularitybyclub", method = RequestMethod.GET)
  // public @ResponseBody String getNutritionalSupplementManufacturerPopularityByClub() {
  //
  // JSONObject json = new JSONObject();
  // Integer i = 0;
  // List<NutritionalSupplement> nutritionalSupplements = nutritionalSupplementService.findAll();
  // for (NutritionalSupplement nutritionalSupplement : nutritionalSupplements) {
  // try {
  //
  // JSONArray jsonArray = new JSONArray().put(new JSONObject().put(
  // "name",
  // nutritionalSupplement.getName() + " - " + nutritionalSupplement.getQuantity()
  // + nutritionalSupplement.getUnit()).put("count",
  // chartService.getClubSupplementUsageCount(nutritionalSupplement.getId())));
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
