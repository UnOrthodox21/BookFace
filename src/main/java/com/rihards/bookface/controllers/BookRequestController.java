package com.rihards.bookface.controllers;

import com.rihards.bookface.items.BookRequestItem;
import com.rihards.bookface.services.BookRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookface/book-requests")
public class BookRequestController {

    private final BookRequestService bookRequestService;

    @Autowired
    public BookRequestController(BookRequestService bookRequestService) {
        this.bookRequestService = bookRequestService;
    }

    @GetMapping
    public List<BookRequestItem> getAllBookRequests() {
        return bookRequestService.getAllBookRequests();
    }

    @GetMapping("/{bookRequestId}")
    public Optional<BookRequestItem> getBookRequestByBookRequestId(@PathVariable("bookRequestId") long bookRequestId) {
        return bookRequestService.getBookRequestByBookRequestId(bookRequestId);
    }

    @PostMapping
    public BookRequestItem createBookRequest(@RequestBody BookRequestItem bookRequestItem) {
        return bookRequestService.createBookRequest(bookRequestItem);
    }

    @DeleteMapping("/{bookRequestId}")
    public void deleteBookRequestById(@PathVariable("bookRequestId") long bookRequestId) {
        bookRequestService.deleteBookRequestById(bookRequestId);
    }

    @PutMapping("/{bookRequestId}")
    public BookRequestItem updateBookRequestById(@RequestBody BookRequestItem bookRequestItem, @PathVariable("bookRequestId") long booKRequestId) {
        return bookRequestService.updateBookRequestById(booKRequestId, bookRequestItem);
    }

}
