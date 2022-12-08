package com.burra.business.responses.author;

import com.burra.entities.Author;

public class UpdateAuthorResponse {
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

  public UpdateAuthorResponse(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public UpdateAuthorResponse() {
  }

  public UpdateAuthorResponse(Author author) {
    this.id = author.getId();
    this.name = author.getName();
  }
}
