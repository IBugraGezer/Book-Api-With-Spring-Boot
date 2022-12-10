package com.burra.business.services.concretes;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import com.burra.business.requests.author.CreateAuthorRequest;
import com.burra.business.requests.author.UpdateAuthorRequest;
import com.burra.business.responses.author.CreateAuthorResponse;
import com.burra.business.responses.author.UpdateAuthorResponse;
import com.burra.business.services.abstracts.AuthorService;
import com.burra.core.exceptions.DataAlreadyExistsException;
import com.burra.core.exceptions.ResourceNotFoundException;
import com.burra.dataAccess.abstracts.AuthorRepository;
import com.burra.entities.Author;

import jakarta.transaction.Transactional;

@Service
public class AuthorManager implements AuthorService {

  private AuthorRepository authorRepository;

  public AuthorManager(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  @Override
  public ArrayList<Author> getAll() {
    return (ArrayList<Author>) authorRepository.findAll();
  }

  @Override
  public CreateAuthorResponse create(CreateAuthorRequest request) throws DataAlreadyExistsException {
    if (authorRepository.existsByName(request.getName())) {
      throw new DataAlreadyExistsException("Bu isimde bir yazar zaten var");
    }
    Author author = new Author();
    author.setName(request.getName());
    Author newAuthor = authorRepository.save(author);

    return new CreateAuthorResponse(newAuthor);
  }

  @Override
  public UpdateAuthorResponse update(UpdateAuthorRequest request, int id) throws ResourceNotFoundException {
    if (!authorRepository.existsById(id)) {
      throw new ResourceNotFoundException("bu id'ye sahip bir yazar bulunamadı");
    }

    Author existingAuthor = authorRepository.getReferenceById(id);
    existingAuthor.setName(request.getName());

    Author updatedAuthor = authorRepository.save(existingAuthor);
    return new UpdateAuthorResponse(updatedAuthor);
  }

  @Override
  @Transactional
  public boolean delete(int id) throws ResourceNotFoundException {
    if (!authorRepository.existsById(id)) {
      throw new ResourceNotFoundException("bu id'ye sahip bir yazar bulunamadı");
    }

    try {
      authorRepository.deleteById(id);
      return true;
    } catch (TransactionSystemException e) {
      return false;
    }
  }

}
