package com.ok.libraryapp.controllers;

import com.ok.libraryapp.models.Author;
import com.ok.libraryapp.models.Book;
import com.ok.libraryapp.models.Publisher;
import com.ok.libraryapp.services.AuthorService;
import com.ok.libraryapp.services.BookService;
import com.ok.libraryapp.services.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
}
