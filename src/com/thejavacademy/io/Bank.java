package com.thejavacademy.io;

import java.io.Serializable;

public class Bank implements Serializable {
  private String name;

  public Bank(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Bank{" + "name='" + name + '\'' + '}';
  }
}
