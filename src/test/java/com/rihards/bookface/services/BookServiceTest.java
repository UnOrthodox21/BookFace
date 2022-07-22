package com.rihards.bookface.services;

import com.rihards.bookface.mappers.BookMapper;
import com.rihards.bookface.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookMapper bookMapper;

    @InjectMocks
    private BookService bookService;

    @Test
    void testGetAllBooks() {

        // Setup

        // Perform

        // Assert

        // Verify

    }

    @Test
    void testGetBookByBookId() {

        // Setup

        // Perform

        // Assert

        // Verify

    }

    @Test
    void testCreateBook() {

        // Setup

        // Perform

        // Assert

        // Verify

    }

    @Test
    void testDeleteBookById() {

        // Setup

        // Perform

        // Assert

        // Verify

    }

    @Test
    void testUpdateBookById() {

        // Setup

        // Perform

        // Assert

        // Verify

    }

}
