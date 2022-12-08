package com.burra.business.services.abstracts;

import java.util.ArrayList;

import com.burra.business.exceptions.DataAlreadyExistsException;
import com.burra.business.exceptions.ResourceNotFoundException;
import com.burra.business.requests.author.CreateAuthorRequest;
import com.burra.business.requests.author.UpdateAuthorRequest;
import com.burra.business.responses.author.CreateAuthorResponse;
import com.burra.business.responses.author.UpdateAuthorResponse;
import com.burra.entities.Author;

public interface AuthorService {
  public ArrayList<Author> getAll();

  public CreateAuthorResponse create(CreateAuthorRequest request) throws DataAlreadyExistsException;

  public UpdateAuthorResponse update(UpdateAuthorRequest request, int id) throws ResourceNotFoundException;
}
