package com.burra.business.services.abstracts;

import java.util.ArrayList;

import com.burra.business.exceptions.DataAlreadyExistsException;
import com.burra.business.requests.book.CreateBookRequest;
import com.burra.business.responses.book.CreateBookResponse;
import com.burra.entities.Book;

public interface BookService {

  public ArrayList<Book> getAll();

  public CreateBookResponse create(CreateBookRequest request) throws DataAlreadyExistsException;

}
