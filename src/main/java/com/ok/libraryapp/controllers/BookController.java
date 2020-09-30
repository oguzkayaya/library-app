package com.ok.libraryapp.controllers;

import com.ok.libraryapp.db.BookSpecification;
import com.ok.libraryapp.models.Author;
import com.ok.libraryapp.models.Book;
import com.ok.libraryapp.models.Publisher;
import com.ok.libraryapp.models.SearchModel;
import com.ok.libraryapp.services.AuthorService;
import com.ok.libraryapp.services.BookService;
import com.ok.libraryapp.services.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BookController {

    private BookService bookService;
    private AuthorService authorService;
    private PublisherService publisherService;

    public BookController(BookService bookService, AuthorService authorService, PublisherService publisherService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getBooks() {
        return "redirect:/books";
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String getBooks(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "/book/bookList";
    }

    @RequestMapping(value = "/books/new", method = RequestMethod.GET)
    public String showBookForm(Book book, Model model) {
        List<Author> authors = authorService.getAuthors();
        List<Publisher> publishers = publisherService.getPublishers();
        model.addAttribute("authors", authors);
        model.addAttribute("publishers", publishers);
        return "/book/bookForm";
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public String saveBook(Book book, Model model) {
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @RequestMapping(value = "/books/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @RequestMapping(value = "/books/update/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable int id, Model model) {
        Book updateBook = bookService.getBook(id);
        model.addAttribute("updateBook", updateBook);
        List<Author> authors = authorService.getAuthors();
        List<Publisher> publishers = publisherService.getPublishers();
        model.addAttribute("authors", authors);
        model.addAttribute("publishers", publishers);
        return "/book/bookUpdateForm";
    }

    @RequestMapping(value = "/books/update/{id}", method = RequestMethod.POST)
    public String updateBook(@PathVariable int id, Book newBook) {
        bookService.updateBook(newBook, id);
        return "redirect:/books";
    }

    @RequestMapping(value = "/books/search", method = RequestMethod.GET)
    public String searchBooks(Model model, SearchModel searchModel) {
        List<Book> results = bookService.searchBooks(searchModel);
        model.addAttribute("books", results);
        model.addAttribute("searchValues", searchModel);
        return "/book/bookList";
    }

}
