package com.burra.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.burra.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
