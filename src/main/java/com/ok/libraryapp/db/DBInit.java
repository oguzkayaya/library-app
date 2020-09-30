package com.ok.libraryapp.db;

import com.ok.libraryapp.models.Author;
import com.ok.libraryapp.models.Book;
import com.ok.libraryapp.models.Publisher;
import com.ok.libraryapp.repositories.AuthorRepository;
import com.ok.libraryapp.repositories.BookRepository;
import com.ok.libraryapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DBInit implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;
    private BookRepository bookRepository;

    public DBInit(AuthorRepository authorRepository, PublisherRepository publisherRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
        this.bookRepository = bookRepository;
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

        Book book1 = new Book("book title 1", "book despriction 1", "series 1", "isbn1", author1, publisher1);
        Book book2 = new Book("book title 2", "book despriction 2", "series 1", "isbn2", author1, publisher2);
        Book book3 = new Book("book title 3", "book despriction 3", "series 1", "isbn3", author2, publisher3);
        Book book4 = new Book("book title 4", "book despriction 4", "series 1", "isbn4", author2, publisher1);
        Book book5 = new Book("book title 5", "book despriction 5", "series 2", "isbn5", author2, publisher2);
        Book book6 = new Book("book title 6", "book despriction 6", "series 2", "isbn6", author3, publisher3);
        Book book7 = new Book("book title 7", "book despriction 7", "series 2", "isbn7", author3, publisher1);
        Book book8 = new Book("book title 8", "book despriction 8", "series 3", "isbn8", author3, publisher2);
        Book book9 = new Book("book title 9", "book despriction 9", "series 3", "isbn9", author1, publisher3);
        Book book10 = new Book("book title 10", "book despriction 10", "series 3", "isbn10", author1, publisher1);
        List<Book> books = Arrays.asList(book1, book2, book3, book4, book5, book6, book7, book8, book9, book10);
        this.bookRepository.saveAll(books);
    }
}
