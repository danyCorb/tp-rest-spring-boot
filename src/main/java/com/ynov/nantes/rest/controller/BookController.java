package com.ynov.nantes.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.nantes.rest.entity.Book;
import com.ynov.nantes.rest.repository.BookRepository;

@RestController
public class BookController {

    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @ResponseBody
    @RequestMapping(value = "/book", method = RequestMethod.GET, params = "title")
    public List<Book> getBooksByTitle(@RequestParam(value = "title", defaultValue = "") String title) {
        List<Book> books = bookRepository.findByTitle(title);
        return books;
    }

    @ResponseBody
    @GetMapping("/book")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/book/{id}")
    public Book getBookById(final @PathVariable("id") String bookId) {
        try {
            Optional<Book> book = bookRepository.findById(Integer.valueOf(bookId));
            return book.get();
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/book")
    public Book addBook(@RequestBody Book book) {
        Book saved = bookRepository.save(book);
        return saved;
    }

}
