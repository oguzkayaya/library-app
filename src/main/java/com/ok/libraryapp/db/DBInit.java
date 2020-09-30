package com.ok.libraryapp.db;

import com.ok.libraryapp.models.Author;
import com.ok.libraryapp.models.Publisher;
import com.ok.libraryapp.repositories.AuthorRepository;
import com.ok.libraryapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DBInit implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    public DBInit(AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author1 = new Author("author1", "desc1", "male", 1990);
        Author author2 = new Author("author2", "desc2", "male", 1980);
        Author author3 = new Author("author3", "desc3", "female", 1980);
        List<Author> authors = Arrays.asList(author1, author2, author3);
        this.authorRepository.saveAll(authors);

        Publisher publisher1 = new Publisher("publisher 1", "publisher description 1");
        Publisher publisher2 = new Publisher("publisher 2", "publisher description 2");
        Publisher publisher3 = new Publisher("publisher 3", "publisher description 3");
        List<Publisher> publishers = Arrays.asList(publisher1, publisher2, publisher3);
        this.publisherRepository.saveAll(publishers);
    }
}
