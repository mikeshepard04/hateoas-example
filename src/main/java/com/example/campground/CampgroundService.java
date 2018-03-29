package com.example.campground;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CampgroundService {

  public List<Campground> getAllCampgrounds() {
    Campground upperPines = new Campground("Upper Pines", 238, Boolean.TRUE, 3);
    Campground tamarackFlat = new Campground("Tamarack FLat", 52, Boolean.TRUE, 3);
    return Arrays.asList(upperPines, tamarackFlat);
  }

  public Campground getCampgroundByParkId(Integer parkId) {
    return getAllCampgrounds().stream()
        .filter(campground -> parkId.equals(campground.getParkId()))
        .findAny()
        .orElse(null);
  }
}
