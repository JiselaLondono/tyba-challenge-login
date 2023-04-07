package com.tyba.challenge.utils;

public enum Resources {

  DEMO_URL("https://www.saucedemo.com/"),
  URI("https://restful-booker.herokuapp.com"),
  END_POINT_AUTH("/auth");

  private final String value;

  Resources(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
