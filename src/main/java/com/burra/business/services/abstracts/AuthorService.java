package com.burra.business.services.abstracts;

import java.util.ArrayList;

import com.burra.business.requests.author.CreateAuthorRequest;
import com.burra.business.requests.author.UpdateAuthorRequest;
import com.burra.business.responses.author.CreateAuthorResponse;
import com.burra.business.responses.author.UpdateAuthorResponse;
import com.burra.core.exceptions.DataAlreadyExistsException;
import com.burra.core.exceptions.ResourceNotFoundException;
import com.burra.entities.Author;

public interface AuthorService {
  public ArrayList<Author> getAll();

  public CreateAuthorResponse create(CreateAuthorRequest request) throws DataAlreadyExistsException;

  public UpdateAuthorResponse update(UpdateAuthorRequest request, int id) throws ResourceNotFoundException;

  public boolean delete(int id) throws ResourceNotFoundException;
}
