package com.rihards.bookface.controllers;

import com.rihards.bookface.items.BookItem;
import com.rihards.bookface.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookface/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookItem> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public Optional<BookItem> getBookByBookId(@PathVariable("bookId") long bookId) {
        return bookService.getBookByBookId(bookId);
    }

    @PostMapping
    public BookItem createBook(@RequestBody BookItem bookItem) {
        return bookService.createBook(bookItem);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBookById(@PathVariable("bookId") long bookId) {
        bookService.deleteBookById(bookId);
    }

    @PutMapping("/{bookId}")
    public BookItem updateBookById(@RequestBody BookItem bookItem, @PathVariable("bookId") long bookId) {
       return bookService.updateBookById(bookId, bookItem);
    }

}
