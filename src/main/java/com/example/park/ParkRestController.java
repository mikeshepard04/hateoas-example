package com.example.park;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/")
public class ParkRestController {

  private final ParkService parkService;

  @Autowired
  public ParkRestController(ParkService parkService) {
    this.parkService = parkService;
  }

  @RequestMapping(method = RequestMethod.GET, produces = MediaTypes.HAL_JSON_VALUE)
  public ResourceSupport index() throws NoSuchMethodException {
    ResourceSupport resource = new ResourceSupport();
    resource.add(linkTo(methodOn(ParkRestController.class).getAllParks()).withRel("All Parks"));
    return resource;
  }

  @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaTypes.HAL_JSON_VALUE)
  public Resources<Park> getAllParks() throws NoSuchMethodException {
    Resources<Park> parkResources = new Resources<>(parkService.getAllParks());
    parkResources.add(linkTo(ParkRestController.class).withSelfRel());
    parkResources.add(linkTo(ParkRestController.class.getMethod("getParkByName", String.class), "Zion").withRel("Zion"));

    return parkResources;
  }

  @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = MediaTypes.HAL_JSON_VALUE)
  public Park getParkByName(@PathVariable("name") String name) throws NoSuchMethodException {
    return parkService.getParkByName(name);
  }

}
