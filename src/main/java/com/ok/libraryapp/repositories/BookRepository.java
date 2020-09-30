package com.ok.libraryapp.repositories;

import com.ok.libraryapp.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
