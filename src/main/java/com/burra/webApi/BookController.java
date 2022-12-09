package com.burra.webApi;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burra.business.exceptions.DataAlreadyExistsException;
import com.burra.business.exceptions.ResourceNotFoundException;
import com.burra.business.requests.book.CreateBookRequest;
import com.burra.business.responses.book.CreateBookResponse;
import com.burra.business.services.abstracts.BookService;
import com.burra.entities.Book;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
public class BookController {
  private BookService bookService;

  BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("")
  public List<Book> getAll() {
    return bookService.getAll();
  }

  @PostMapping("")
  public ResponseEntity<CreateBookResponse> create(@Valid @RequestBody CreateBookRequest request)
      throws DataAlreadyExistsException, ResourceNotFoundException {
    CreateBookResponse response = bookService.create(request);
    return ResponseEntity.ok().body(response);
  }

}
