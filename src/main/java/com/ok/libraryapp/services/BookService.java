package com.ok.libraryapp.services;

import com.ok.libraryapp.db.BookSpecification;
import com.ok.libraryapp.db.SearchCriteria;
import com.ok.libraryapp.models.Book;
import com.ok.libraryapp.models.SearchModel;
import com.ok.libraryapp.repositories.BookRepository;
import org.springframework.data.jpa.domain.Specification;
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

    public Book getBook(int id) {
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


    public List<Book> searchBooks(SearchModel searchModel) {
        BookSpecification titleSpec = null;
        BookSpecification seriesSpec = null;
        BookSpecification isbnSpec = null;
        if (searchModel.getTitle() != null)
            titleSpec = new BookSpecification(
                    new SearchCriteria("title", searchModel.getTitle().toLowerCase()));
        if (searchModel.getSeries() != null)
            seriesSpec = new BookSpecification(
                    new SearchCriteria("series", searchModel.getSeries().toLowerCase()));
        if (searchModel.getIsbn() != null)
            isbnSpec = new BookSpecification(
                    new SearchCriteria("isbn", searchModel.getIsbn().toLowerCase()));

        Specification spec = Specification.where(titleSpec).and(seriesSpec).and(isbnSpec);
        List<Book> result = bookRepository.findAll(spec);
        return result;
    }
}
