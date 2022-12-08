package com.burra.business.requests;

public class CreateAuthorRequest {
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreateAuthorRequest(String name) {
    this.name = name;
  }

  public CreateAuthorRequest() {
  }
}
