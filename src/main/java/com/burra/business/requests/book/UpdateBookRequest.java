package com.burra.business.requests.book;

import com.burra.entities.Book;

public class UpdateBookRequest {

  public UpdateBookRequest() {
  }

  public UpdateBookRequest(String name) {
    this.name = name;
  }

  public UpdateBookRequest(Book book) {
    this.name = book.getName();
  }

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
