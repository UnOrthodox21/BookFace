package com.rihards.bookface.services;

import com.rihards.bookface.entities.BookEntity;
import com.rihards.bookface.entities.BookRequestEntity;
import com.rihards.bookface.entities.CustomerEntity;
import com.rihards.bookface.items.BookItem;
import com.rihards.bookface.items.BookRequestItem;
import com.rihards.bookface.items.CustomerItem;
import com.rihards.bookface.mappers.BookMapper;
import com.rihards.bookface.mappers.BookRequestMapper;
import com.rihards.bookface.mappers.CustomerMapper;
import com.rihards.bookface.repositories.BookRepository;
import com.rihards.bookface.repositories.BookRequestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class BookRequestServiceTest {

    @Mock
    private BookRequestRepository bookRequestRepository;

    @Mock
    private BookRequestMapper bookRequestMapper;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private CustomerMapper customerMapper;

    @Mock
    private BookMapper bookMapper;

    @Mock
    BookService bookService;

    @InjectMocks
    BookRequestService bookRequestService;

    BookRequestEntity bookRequestEntity = new BookRequestEntity();
    BookRequestItem bookRequestItem = new BookRequestItem.Builder().build();


    @BeforeEach
    public void setup() {
        bookRequestEntity = getBookRequestEntity();
        bookRequestItem = getBookRequestItem();
    }

    @Test
    void testGetAllBookRequests() {

        List<BookRequestEntity> bookRequestEntityList = new ArrayList<BookRequestEntity>();
        bookRequestEntityList.add(bookRequestEntity);

        // Mock
        when(bookRequestRepository.findAll()).thenReturn(bookRequestEntityList);
        when(bookRequestMapper.toBookRequestEntity(bookRequestItem)).thenReturn(bookRequestEntity);
        when(bookRequestMapper.toBookRequestItem(bookRequestEntity)).thenReturn(bookRequestItem);

        // Perform
        List<BookRequestItem> foundBookRequestItemList = bookRequestService.getAllBookRequests();
        BookRequestItem firstFoundBookRequestItem = foundBookRequestItemList.get(0);

        // Assert
        assert (foundBookRequestItemList.size() == 1);
        assert (firstFoundBookRequestItem.getId() == bookRequestItem.getId());
        assert (firstFoundBookRequestItem.getAuthor()).equals(bookRequestItem.getAuthor());
        assert (firstFoundBookRequestItem.getStatus()).equals(bookRequestItem.getStatus());
        assert (firstFoundBookRequestItem.getTitle()).equals(bookRequestItem.getTitle());
        assert (firstFoundBookRequestItem.getPages() == bookRequestItem.getPages());
        assert (firstFoundBookRequestItem.getPublishingYear() == bookRequestItem.getPublishingYear());
        assert (firstFoundBookRequestItem.getCreationDateAndTime()).equals(bookRequestItem.getCreationDateAndTime());
        assert (firstFoundBookRequestItem.getEndDate()).equals(bookRequestItem.getEndDate());
        assert (firstFoundBookRequestItem.getCustomer().getId() == bookRequestItem.getCustomer().getId());

    }

    @Test
    void testGetBookRequestByBookRequestId() {

        // Mock
        when(bookRequestRepository.findById(bookRequestEntity.getId())).thenReturn(Optional.of(bookRequestEntity));
        when(bookRequestMapper.toBookRequestEntity(bookRequestItem)).thenReturn(bookRequestEntity);
        when(bookRequestMapper.toBookRequestItem(bookRequestEntity)).thenReturn(bookRequestItem);
        when(customerMapper.toCustomerEntity(any(CustomerItem.class))).thenReturn(new CustomerEntity());
        when(customerMapper.toCustomerItem(any(CustomerEntity.class))).thenReturn(new CustomerItem.Builder().build());

        // Perform
        Optional<BookRequestItem> foundBookRequestItem = bookRequestService.getBookRequestByBookRequestId(bookRequestEntity.getId());

        // Assert
        assert (foundBookRequestItem.get().getId() == bookRequestItem.getId());
        assert (foundBookRequestItem.get().getAuthor()).equals(bookRequestItem.getAuthor());
        assert (foundBookRequestItem.get().getTitle()).equals(bookRequestItem.getTitle());
        assert (foundBookRequestItem.get().getStatus()).equals(bookRequestItem.getStatus());
        assert (foundBookRequestItem.get().getPages() == bookRequestItem.getPages());
        assert (foundBookRequestItem.get().getCustomer().getId()) == (bookRequestItem.getCustomer().getId());
        assert (foundBookRequestItem.get().getPublishingYear() == bookRequestItem.getPublishingYear());
        assert (foundBookRequestItem.get().getCreationDateAndTime()).equals(bookRequestItem.getCreationDateAndTime());
        assert (foundBookRequestItem.get().getEndDate()).equals(bookRequestItem.getEndDate());

        // Verify
        verify(bookRequestRepository, times(1)).findById(bookRequestEntity.getId());

    }

    @Test
    void testCreateBookRequest() {

        // Mock
        when(bookRequestRepository.save(bookRequestEntity)).thenReturn(bookRequestEntity);
        when(bookRequestMapper.toBookRequestEntity(bookRequestItem)).thenReturn(bookRequestEntity);
        when(bookRequestMapper.toBookRequestItem(bookRequestEntity)).thenReturn(bookRequestItem);

        // Perform
        BookRequestItem createdBookRequestItem = bookRequestService.createBookRequest(bookRequestItem);

        // Assert
        assert (createdBookRequestItem.getTitle()).equals(bookRequestItem.getTitle());


        // Verify
        verify(bookRequestRepository, times(1)).save(bookRequestEntity);

    }

    @Test
    void testDeleteBookRequestById() {

        // Perform
        bookRequestService.deleteBookRequestById(bookRequestEntity.getId());

        // Verify
        verify(bookRequestRepository, times(1)).deleteById(bookRequestEntity.getId());

    }

    @Test
    void testUpdateBookRequestById() {

        // Mock
        when(bookRequestRepository.findById(bookRequestEntity.getId())).thenReturn(Optional.of(bookRequestEntity));
        when(bookRequestRepository.save(bookRequestEntity)).thenReturn(bookRequestEntity);
        when(bookRequestMapper.toBookRequestEntity(bookRequestItem)).thenReturn(bookRequestEntity);
        when(bookRequestMapper.toBookRequestItem(bookRequestEntity)).thenReturn(bookRequestItem);

        // Perform
        BookRequestItem updatedBookRequestItem = bookRequestService.updateBookRequestById(bookRequestItem.getId(), bookRequestItem);

        // Assert
        assert (updatedBookRequestItem.getAuthor()).equals(bookRequestItem.getAuthor());

        // Verify
        verify(bookRequestRepository, times(1)).save(bookRequestEntity);

    }

    @Test
    void testCompleteBookRequest() {

        // Setup
        BookRequestEntity bookRequestEntityWithUpdates = getBookRequestEntity();
        bookRequestEntityWithUpdates.setStatus("COMPLETED");
        bookRequestEntityWithUpdates.setEndDate(LocalDate.now());

        BookRequestItem bookRequestItemWithUpdates = new BookRequestItem
                .Builder()
                .author(bookRequestEntityWithUpdates.getAuthor())
                .pages(bookRequestEntityWithUpdates.getPages())
                .title(bookRequestEntityWithUpdates.getStatus())
                .status("COMPLETED")
                .publishingYear(bookRequestEntityWithUpdates.getPublishingYear())
                .endDate(bookRequestEntityWithUpdates.getEndDate())
                .creationDateAndTime(bookRequestEntityWithUpdates.getCreationDateAndTime())
                .build();


        BookItem bookItemFromBookRequest = new BookItem.Builder()
                .author(bookRequestEntity.getAuthor())
                .title(bookRequestEntity.getTitle())
                .publishingYear(bookRequestEntity.getPublishingYear())
                .pages(bookRequestEntity.getPages())
                .build();


        BookEntity bookEntityFromRequest = new BookEntity();
        bookEntityFromRequest.setAuthor(bookRequestEntity.getAuthor());
        bookEntityFromRequest.setTitle(bookRequestEntity.getTitle());
        bookEntityFromRequest.setPublishingYear(bookRequestEntity.getPublishingYear());
        bookEntityFromRequest.setPages(bookRequestEntity.getPages());

        // Mock
        when(bookRequestRepository.findById(anyLong())).thenReturn(Optional.of(bookRequestEntity));
        when(bookRequestMapper.toBookRequestEntity(any(BookRequestItem.class))).thenReturn(bookRequestEntityWithUpdates);
        when(bookRequestMapper.toBookRequestItem(any(BookRequestEntity.class))).thenReturn(bookRequestItemWithUpdates);
        when(bookMapper.toBookItem(any(BookEntity.class))).thenReturn(bookItemFromBookRequest);
        when(bookMapper.toBookEntity(any(BookItem.class))).thenReturn(bookEntityFromRequest);
        when(bookRepository.save(any(BookEntity.class))).thenReturn(bookEntityFromRequest);
        when(bookRequestRepository.save(any(BookRequestEntity.class))).thenReturn(bookRequestEntityWithUpdates);
        when(bookService.createBook(bookItemFromBookRequest)).thenReturn(bookItemFromBookRequest);


        // Perform
        BookRequestItem completedBookRequestItem = bookRequestService.completeBookRequest(bookRequestItem.getId());

        // Assert
        assert (completedBookRequestItem.getStatus()).equals(bookRequestEntityWithUpdates.getStatus());

        // Verify
        verify(bookRequestRepository, times(1)).save(bookRequestEntity);

    }

    @Test
    void testRejectBookRequest() {

        // Setup
        BookRequestEntity bookRequestEntityWithUpdates = getBookRequestEntity();
        bookRequestEntityWithUpdates.setStatus("COMPLETED");
        bookRequestEntityWithUpdates.setEndDate(LocalDate.now());

        BookRequestItem bookRequestItemWithUpdates = new BookRequestItem
                .Builder()
                .author(bookRequestEntityWithUpdates.getAuthor())
                .pages(bookRequestEntityWithUpdates.getPages())
                .title(bookRequestEntityWithUpdates.getStatus())
                .status("REJECTED")
                .publishingYear(bookRequestEntityWithUpdates.getPublishingYear())
                .endDate(bookRequestEntityWithUpdates.getEndDate())
                .creationDateAndTime(bookRequestEntityWithUpdates.getCreationDateAndTime())
                .build();


        // Mock
        when(bookRequestRepository.findById(bookRequestEntity.getId())).thenReturn(Optional.of(bookRequestEntity));
        when(bookRequestRepository.save(bookRequestEntity)).thenReturn(bookRequestEntityWithUpdates);
        when(bookRequestMapper.toBookRequestEntity(any(BookRequestItem.class))).thenReturn(bookRequestEntityWithUpdates);
        when(bookRequestMapper.toBookRequestItem(any(BookRequestEntity.class))).thenReturn(bookRequestItemWithUpdates);

        // Perform
        BookRequestItem updatedBookRequestItem = bookRequestService.rejectBookRequest(bookRequestItem.getId());

        // Assert
        assert (updatedBookRequestItem.getStatus()).equals("REJECTED");

        // Verify
        verify(bookRequestRepository, times(1)).save(bookRequestEntity);

    }

    // Helper functions

    private BookRequestEntity getBookRequestEntity() {
        BookRequestEntity bookRequestEntity = new BookRequestEntity();
        bookRequestEntity.setId(6L);
        bookRequestEntity.setAuthor("TEST AUTHOR");
        bookRequestEntity.setTitle("TEST BOOK");
        bookRequestEntity.setPublishingYear(1995);
        bookRequestEntity.setPages(321);
        bookRequestEntity.setStatus("TEST STATUS");
        bookRequestEntity.setCustomer(new CustomerEntity());
        bookRequestEntity.setCreationDateAndTime(LocalDateTime.now());
        bookRequestEntity.setEndDate(LocalDate.now());

        return bookRequestEntity;
    }

    private BookRequestItem getBookRequestItem() {
        return new BookRequestItem
                .Builder()
                .id(6L)
                .author("TEST AUTHOR")
                .title("TEST BOOK")
                .publishingYear(1995)
                .pages(321)
                .status("TEST STATUS")
                .customer(new CustomerItem.Builder().build())
                .creationDateAndTime(LocalDateTime.now())
                .endDate(LocalDate.now())
                .build();
    }


}
