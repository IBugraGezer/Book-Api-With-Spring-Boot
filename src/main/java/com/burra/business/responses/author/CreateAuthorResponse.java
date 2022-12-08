package com.burra.business.responses;

import com.burra.entities.Author;

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

  public CreateAuthorResponse(Author author) {
    this.id = author.getId();
    this.name = author.getName();
  }
}
