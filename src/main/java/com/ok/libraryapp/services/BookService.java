package com.ok.libraryapp.services;

import com.ok.libraryapp.models.Book;
import com.ok.libraryapp.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    public Book getBook(int id){
        return bookRepository.findById(id).get();
    }

    public void updateBook(Book book, int id) {
        Book b = bookRepository.findById(id).get();
        b.setTitle(book.getTitle());
        b.setDescription(book.getDescription());
        b.setIsbn(book.getIsbn());
        b.setSeries(book.getSeries());
        b.setAuthor(book.getAuthor());
        b.setPublisher(book.getPublisher());
        bookRepository.save(b);
    }
}
