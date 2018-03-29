package com.example.park;

import com.example.campground.CampgroundRestController;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;


@Service
public class ParkService {

  public List<Park> getAllParks() throws NoSuchMethodException {
    Park canyonLands = new Park(1, "Canyonlands", "Utah", 337597, 742271);
    Park zion = new Park(1, "Zion", "Utah", 147237, 4504812);
    Park yosemite = new Park(3, "Yosemite", "California", 761747, 4336890);
    yosemite.add(linkTo(CampgroundRestController.class.getMethod("getCampgroundByParkId", Integer.class), 3).withRel("Campgrounds"));
    Park grandCanyon = new Park(4, "Grand Canyon", "Arizona", 1201647, 6254238);
    Park deathValley = new Park(5, "Death Valley", "California, Nevada", 3373063, 1294827);
    Park bryceCanyon = new Park(6, "Bryce Canyon", "Utah", 35835, 2571684);

    return Arrays.asList(canyonLands, zion, yosemite, grandCanyon, deathValley, bryceCanyon);
  }

  public Park getParkByName(String name) throws NoSuchMethodException {
    return getAllParks().stream()
        .filter(park -> name.equals(park.getName()))
        .findFirst()
        .orElse(null);
  }
}
