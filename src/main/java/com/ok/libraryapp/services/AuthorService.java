package com.ok.libraryapp.services;

import com.ok.libraryapp.models.Author;
import com.ok.libraryapp.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }
}
