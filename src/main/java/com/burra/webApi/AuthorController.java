package com.burra.webApi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burra.business.exceptions.DataAlreadyExistsException;
import com.burra.business.requests.author.CreateAuthorRequest;
import com.burra.business.responses.author.CreateAuthorResponse;
import com.burra.business.services.abstracts.AuthorService;
import com.burra.entities.Author;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
  private AuthorService authorService;

  AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @GetMapping("")
  public ResponseEntity<List<Author>> getAll() {
    ArrayList<Author> authors = authorService.getAll();

    return ResponseEntity.ok().body(authors);
  }

  @PostMapping("")
  public ResponseEntity<CreateAuthorResponse> create(@Valid @RequestBody CreateAuthorRequest request)
      throws DataAlreadyExistsException {
    try {
      CreateAuthorResponse response = authorService.create(request);
      return ResponseEntity.ok().body(response);
    } catch (DataAlreadyExistsException e) {
      throw e;
    }

  }

}
