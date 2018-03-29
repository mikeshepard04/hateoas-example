package com.example.campground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/campground")
public class CampgroundRestController {

  private final CampgroundService campgroundService;

  @Autowired
  public CampgroundRestController(CampgroundService campgroundService) {
    this.campgroundService = campgroundService;
  }

  @RequestMapping(value = "/{parkId}", method = RequestMethod.GET, produces = MediaTypes.HAL_JSON_VALUE)
  public Campground getCampgroundByParkId(@PathVariable("parkId") Integer parkId) {
    return campgroundService.getCampgroundByParkId(parkId);
  }

}
