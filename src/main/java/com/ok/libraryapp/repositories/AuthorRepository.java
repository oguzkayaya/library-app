package com.ok.libraryapp.repositories;

import com.ok.libraryapp.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
