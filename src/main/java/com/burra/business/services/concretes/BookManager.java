package com.burra.business.services.concretes;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.burra.business.exceptions.DataAlreadyExistsException;
import com.burra.business.exceptions.ResourceNotFoundException;
import com.burra.business.requests.book.CreateBookRequest;
import com.burra.business.responses.book.CreateBookResponse;
import com.burra.business.services.abstracts.BookService;
import com.burra.dataAccess.abstracts.AuthorRepository;
import com.burra.dataAccess.abstracts.BookRepository;
import com.burra.entities.Author;
import com.burra.entities.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class BookManager implements BookService {

  private BookRepository bookRepository;
  private AuthorRepository authorRepository;

  @PersistenceContext
  private EntityManager entityManager;

  public BookManager(BookRepository bookRepository, AuthorRepository authorRepository) {
    this.bookRepository = bookRepository;
    this.authorRepository = authorRepository;
  }

  @Override
  public ArrayList<Book> getAll() {
    ArrayList<Book> books = (ArrayList<Book>) bookRepository.findAll();

    return books;
  }

  @Override
  public CreateBookResponse create(CreateBookRequest request)
      throws DataAlreadyExistsException, ResourceNotFoundException {
    int authorId = request.getAuthorId();
    if (!authorRepository.existsById(authorId)) {
      throw new DataAlreadyExistsException("bu id ye sahip bir yazar bulunamıyor");
    }
    String query = "SELECT COUNT(b) FROM Book b WHERE b.author.id=:authorId AND b.name=:bookName";
    boolean bookExists = (Long) entityManager.createQuery(query)
        .setParameter("authorId", authorId)
        .setParameter("bookName", request.getName())
        .getSingleResult() > 0;

    if (bookExists) {
      throw new DataAlreadyExistsException("bu yazarda bu adda bir kitap zaten kayıtlı");
    }

    Author author = authorRepository.getReferenceById(authorId);

    Book book = new Book();
    book.setName(request.getName());
    book.setAuthor(author);

    entityManager.persist(book);

    return new CreateBookResponse(book);
  }
}
