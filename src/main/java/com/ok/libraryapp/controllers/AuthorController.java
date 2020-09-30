package com.ok.libraryapp.controllers;

import com.ok.libraryapp.models.Author;
import com.ok.libraryapp.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/authors/new", method = RequestMethod.GET)
    public String showAuthorForm() {
        return "/author/authorForm";
    }

    @RequestMapping(value = "/authors", method = RequestMethod.POST)
    public String addAuthor(Author author, Model model) {
        authorService.saveAuthor(author);
        return "redirect:/authors";
    }

    @RequestMapping(value = "/authors/delete/{id}", method = RequestMethod.GET)
    public String deleteAuthor(@PathVariable int id) {
        authorService.deleteAuthor(id);
        return "redirect:/authors";
    }

    @RequestMapping(value = "/authors/update/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable int id, Model model) {
        Author author = authorService.getAuthor(id);
        model.addAttribute("updateAuthor", author);
        return "/author/authorUpdateForm";
    }

    @RequestMapping(value = "/authors/update/{id}", method = RequestMethod.POST)
    public String updateAuthor(@PathVariable int id, Author newAuthor) {
        authorService.updateAuthor(newAuthor, id);
        return "redirect:/authors";
    }


}
