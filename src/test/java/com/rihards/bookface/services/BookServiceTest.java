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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;


@ExtendWith(SpringExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookMapper bookMapper;

    @InjectMocks
    BookService bookService;

    BookEntity bookEntity = new BookEntity();
    BookItem bookItem = new BookItem.Builder().build();


    @BeforeEach
    public void setup() {
        bookEntity = getBookEntity();
        bookItem = getBookItem();
    }

    @Test
    void testGetAllBooks() {

        List<BookEntity> bookEntityList = new ArrayList<BookEntity>();
        bookEntityList.add(bookEntity);

        // Mock
        when(bookRepository.findAll()).thenReturn(bookEntityList);
        when(bookMapper.toBookEntity(bookItem)).thenReturn(bookEntity);
        when(bookMapper.toBookItem(bookEntity)).thenReturn(bookItem);

        // Perform
        List<BookItem> foundBookItemList = bookService.getAllBooks();
        BookItem firstFoundBookItem = foundBookItemList.get(0);

        // Assert
        assert (foundBookItemList.size() == 1);
        assert (firstFoundBookItem.getId() == bookItem.getId());
        assert (firstFoundBookItem.getAuthor()).equals(bookItem.getAuthor());
        assert (firstFoundBookItem.getTitle()).equals(bookItem.getTitle());
        assert (firstFoundBookItem.getPages() == bookItem.getPages());
        assert (firstFoundBookItem.getPublishingYear() == bookItem.getPublishingYear());

    }

    @Test
    void testGetBookByBookId() {

        // Mock
        when(bookRepository.findById(bookEntity.getId())).thenReturn(Optional.of(bookEntity));
        when(bookMapper.toBookEntity(bookItem)).thenReturn(bookEntity);
        when(bookMapper.toBookItem(bookEntity)).thenReturn(bookItem);

        // Perform
        Optional<BookItem> foundBookItem = bookService.getBookByBookId(bookEntity.getId());

        // Assert
        assert (foundBookItem.get().getId() == bookItem.getId());
        assert (foundBookItem.get().getAuthor()).equals(bookItem.getAuthor());
        assert (foundBookItem.get().getTitle()).equals(bookItem.getTitle());
        assert (foundBookItem.get().getPages() == bookItem.getPages());
        assert (foundBookItem.get().getPublishingYear() == bookItem.getPublishingYear());

        // Verify
        verify(bookRepository, times(1)).findById(bookEntity.getId());

    }

    @Test
    void testCreateBook() {

        // Mock
        when(bookRepository.save(bookEntity)).thenReturn(bookEntity);
        when(bookMapper.toBookEntity(bookItem)).thenReturn(bookEntity);
        when(bookMapper.toBookItem(bookEntity)).thenReturn(bookItem);

        // Perform
        BookItem createdBookItem = bookService.createBook(bookItem);

        // Assert
        assert (createdBookItem.getTitle()).equals(bookItem.getTitle());


        // Verify
        verify(bookRepository, times(1)).save(bookEntity);

    }

    @Test
    void testDeleteBookById() {

        // Perform
        bookService.deleteBookById(bookEntity.getId());

        // Verify
        verify(bookRepository, times(1)).deleteById(bookEntity.getId());

    }

    @Test
    void testUpdateBookById() {

        // Mock
        when(bookRepository.findById(bookEntity.getId())).thenReturn(Optional.of(bookEntity));
        when(bookRepository.save(bookEntity)).thenReturn(bookEntity);
        when(bookMapper.toBookEntity(bookItem)).thenReturn(bookEntity);
        when(bookMapper.toBookItem(bookEntity)).thenReturn(bookItem);

        // Perform
        BookItem updatedBookItem = bookService.updateBookById(bookItem.getId(), bookItem);

        // Assert
        assert (updatedBookItem.getTitle()).equals(bookItem.getTitle());

        // Verify
        verify(bookRepository, times(1)).save(bookEntity);

    }

    // Helper functions

    private BookEntity getBookEntity() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(6L);
        bookEntity.setAuthor("Test Author");
        bookEntity.setTitle("Test Title");
        bookEntity.setPublishingYear(1923);
        bookEntity.setPages(345);
        return bookEntity;
    }

    private BookItem getBookItem() {
        return new BookItem
                .Builder()
                .id(6L)
                .author("Test Author")
                .title("Test Title")
                .publishingYear(1923)
                .pages(345)
                .build();
    }

}
