package com.ok.libraryapp.db;

import com.ok.libraryapp.models.Author;
import com.ok.libraryapp.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DBInit implements CommandLineRunner {

    private AuthorRepository authorRepository;

    public DBInit(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author1 = new Author("author1", "desc1", "male", 1990);
        Author author2 = new Author("author2", "desc2", "male", 1980);
        Author author3 = new Author("author3", "desc3", "female", 1980);
        List<Author> authors = Arrays.asList(author1, author2, author3);
        this.authorRepository.saveAll(authors);
    }
}
