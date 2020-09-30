package com.ok.libraryapp.controllers;

import com.ok.libraryapp.models.Book;
import com.ok.libraryapp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String getBooks(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "/book/bookList";
    }
}
