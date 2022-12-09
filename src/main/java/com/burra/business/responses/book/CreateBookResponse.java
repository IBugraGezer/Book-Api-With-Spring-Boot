package com.burra.business.responses.book;

import com.burra.entities.Author;
import com.burra.entities.Book;

public class CreateBookResponse {
  public CreateBookResponse() {
  }

  public CreateBookResponse(int id, Author author, String name) {
    this.id = id;
    this.author = author;
    this.name = name;
  }

  public CreateBookResponse(Book book) {
    this.id = book.getId();
    this.author = book.getAuthor();
    this.name = book.getName();
  }

  private int id;
  private Author author;
  private String name;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
