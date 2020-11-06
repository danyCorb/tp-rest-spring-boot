package com.ynov.nantes.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.nantes.rest.entity.Author;
import com.ynov.nantes.rest.repository.AuthorRepository;

@RestController
public class AuthorController {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @ResponseBody
    @GetMapping("/author/{id}")
    public Author getAuthorById(final @PathVariable("id") String authorId) {
        try {
            Optional<Author> author = authorRepository.findById(Integer.valueOf(authorId));
            return author.get();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/author")
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @PostMapping("/author")
    public Author addAuthor(@RequestBody Author author) {
        Author saved = authorRepository.save(author);
        return saved;
    }

    @ResponseBody
    @PutMapping("/author/{id}")
    public Author editAuthor(@RequestBody Author author) {
        Author updated = authorRepository.save(author);
        return updated;
    }

}
