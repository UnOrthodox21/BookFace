package com.rihards.bookface.services;

import com.rihards.bookface.entities.BookEntity;
import com.rihards.bookface.items.BookItem;
import com.rihards.bookface.mappers.BookMapper;
import com.rihards.bookface.repositories.BookRepository;
import org.junit.jupiter.api.BeforeEach;
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

    private BookEntity bookEntity;
    private BookItem bookItem;

    @BeforeEach
    public void setup() {
//        bookEntity = getBookEntity();
        bookItem = getBookItem();
    }

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
//    when(bookRepository.findById()).thenReturn(Optional.ofNullable(bookEntity))
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

    // Helper functions


//    public BookEntity getBookEntity() {
//    }

    public BookItem getBookItem() {
        return new BookItem.Builder().id(6L).author("Test Author").title("Test Title").pages(65).publishingYear(1952).build();
    }

}
