package com.ok.libraryapp.controllers;

import com.ok.libraryapp.models.Author;
import com.ok.libraryapp.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public String showAuthorList(Model model) {
        List<Author> authorList = authorService.getAuthors();
        model.addAttribute("authors", authorList);
        return "/author/authorList";
    }
}
