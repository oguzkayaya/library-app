package com.ok.libraryapp.services;

import com.ok.libraryapp.models.Author;
import com.ok.libraryapp.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
    }

    public void updateAuthor(Author author, int id) {
        Author a = getAuthor(id);
        a.setName(author.getName());
        a.setDescription(author.getDescription());
        a.setBirthDate(author.getBirthDate());
        a.setGender(author.getGender());
        authorRepository.save(a);
    }

    public Author getAuthor(int id){
        return authorRepository.findById(id).get();
    }

}
