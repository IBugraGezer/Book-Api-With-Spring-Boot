package com.burra.business.responses;

public class CreateAuthorResponse {
  private int id;
  private String name;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreateAuthorResponse(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public CreateAuthorResponse() {
  }
}
