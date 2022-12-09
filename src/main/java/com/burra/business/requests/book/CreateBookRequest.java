package com.burra.business.requests.book;

public class CreateBookRequest {

  public CreateBookRequest() {
  }

  public CreateBookRequest(int id, int authorId, String name) {
    this.id = id;
    this.authorId = authorId;
    this.name = name;
  }

  private int id;
  private int authorId;
  private String name;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getAuthorId() {
    return authorId;
  }

  public void setAuthorId(int authorId) {
    this.authorId = authorId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
