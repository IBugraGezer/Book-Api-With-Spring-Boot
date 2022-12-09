package com.burra.business.requests.author;

public class UpdateAuthorRequest {
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UpdateAuthorRequest(String name) {
    this.name = name;
  }

  public UpdateAuthorRequest() {
  }
}
