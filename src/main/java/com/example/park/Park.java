package com.example.park;

import org.springframework.hateoas.ResourceSupport;

public class Park extends ResourceSupport {

  private Integer parkId;

  private String name;

  private String location;

  private Integer size;

  private Integer visitors;

  public Park(Integer parkId, String name, String location, Integer size, Integer visitors) {
    this.parkId = parkId;
    this.name = name;
    this.location = location;
    this.size = size;
    this.visitors = visitors;
  }

  public Integer getParkId() {
    return parkId;
  }

  public void setParkId(Integer parkId) {
    this.parkId = parkId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public Integer getVisitors() {
    return visitors;
  }

  public void setVisitors(Integer visitors) {
    this.visitors = visitors;
  }
}
