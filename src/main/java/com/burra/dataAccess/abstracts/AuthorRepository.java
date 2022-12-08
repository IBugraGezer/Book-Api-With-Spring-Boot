package com.burra.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.burra.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
