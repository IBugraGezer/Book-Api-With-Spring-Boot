package com.burra.business.services.abstracts;

import java.util.ArrayList;

import com.burra.business.requests.author.CreateAuthorRequest;
import com.burra.business.responses.author.CreateAuthorResponse;
import com.burra.entities.Author;

public interface AuthorService {
  public ArrayList<Author> getAll();

  public CreateAuthorResponse create(CreateAuthorRequest request);
}
