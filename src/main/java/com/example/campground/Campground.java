package com.example.campground;

import org.springframework.hateoas.ResourceSupport;

public class Campground extends ResourceSupport {

  String name;

  Integer sites;

  Boolean water;

  Integer parkId;

  public Campground(String name, Integer sites, Boolean water, Integer parkId) {
    this.name = name;
    this.sites = sites;
    this.water = water;
    this.parkId = parkId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getSites() {
    return sites;
  }

  public void setSites(Integer sites) {
    this.sites = sites;
  }

  public Boolean getWater() {
    return water;
  }

  public void setWater(Boolean water) {
    this.water = water;
  }

  public Integer getParkId() {
    return parkId;
  }

  public void setParkId(Integer parkId) {
    this.parkId = parkId;
  }
}
