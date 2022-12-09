package com.burra.webApi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burra.business.exceptions.DataAlreadyExistsException;
import com.burra.business.exceptions.ResourceNotFoundException;
import com.burra.business.requests.author.CreateAuthorRequest;
import com.burra.business.requests.author.UpdateAuthorRequest;
import com.burra.business.responses.author.CreateAuthorResponse;
import com.burra.business.responses.author.UpdateAuthorResponse;
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
    CreateAuthorResponse response = authorService.create(request);
    return ResponseEntity.ok().body(response);

  }

  @PutMapping("/{id}")
  public ResponseEntity<UpdateAuthorResponse> update(@Valid @RequestBody UpdateAuthorRequest request,
      @PathVariable int id)
      throws ResourceNotFoundException {

    UpdateAuthorResponse response = authorService.update(request, id);
    return ResponseEntity.ok().body(response);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable int id) throws ResourceNotFoundException {
    authorService.delete(id);

    return ResponseEntity.ok().body("silindi");
  }

}
