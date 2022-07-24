package com.rihards.bookface.mappers;

import com.rihards.bookface.entities.BookEntity;
import com.rihards.bookface.entities.BorrowPeriodEntity;
import com.rihards.bookface.entities.CustomerEntity;
import com.rihards.bookface.items.BookItem;
import com.rihards.bookface.items.BorrowPeriodItem;
import com.rihards.bookface.items.CustomerItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BorrowPeriodMapperTest {

    @Mock
    private CustomerMapper customerMapper;

    @Mock
    private BookMapper bookMapper;

    @InjectMocks
    private BorrowPeriodMapper borrowPeriodMapper;

    @Test
    void testToBorrowPeriodItem() {

        // Setup
        CustomerEntity customerEntity = getCustomerEntity();
        BookEntity bookEntity = getBookEntity();

        BorrowPeriodEntity borrowPeriodEntity = new BorrowPeriodEntity();
        borrowPeriodEntity.setId(6L);
        borrowPeriodEntity.setCustomer(customerEntity);
        borrowPeriodEntity.setBook(bookEntity);
        borrowPeriodEntity.setStatus("TEST STATUS");
        borrowPeriodEntity.setCreationDateAndTime(LocalDateTime.now());
        borrowPeriodEntity.setStartDate(LocalDate.now());
        borrowPeriodEntity.setEndDate(LocalDate.now());

        // Mock
        when(customerMapper.toCustomerItem(customerEntity)).thenReturn(getCustomerItem());
        when(bookMapper.toBookItem(bookEntity)).thenReturn(getBookItem());

        // Perform
        BorrowPeriodItem borrowPeriodItem = borrowPeriodMapper.toBorrowPeriodItem(borrowPeriodEntity);

        // Verify
        assertThat(borrowPeriodItem.getId()).isEqualTo(borrowPeriodEntity.getId());
        assertThat(borrowPeriodItem.getCustomer().getId()).isEqualTo(borrowPeriodEntity.getCustomer().getId());
        assertThat(borrowPeriodItem.getBook().getId()).isEqualTo(borrowPeriodEntity.getBook().getId());
        assertThat(borrowPeriodItem.getStatus()).isEqualTo(borrowPeriodEntity.getStatus());
        assertThat(borrowPeriodItem.getCreationDateAndTime()).isEqualTo(borrowPeriodEntity.getCreationDateAndTime());
        assertThat(borrowPeriodItem.getStartDate()).isEqualTo(borrowPeriodEntity.getStartDate());
        assertThat(borrowPeriodItem.getEndDate()).isEqualTo(borrowPeriodEntity.getEndDate());


    }

    @Test
    void testToBorrowPeriodEntity() {

        //Setup
        CustomerItem customerItem = getCustomerItem();
        BookItem bookItem = getBookItem();

        BorrowPeriodItem borrowPeriodItem = new BorrowPeriodItem
                .Builder()
                .id(6L)
                .customer(customerItem)
                .book(bookItem)
                .status("TEST STATUS")
                .creationDateAndTime(LocalDateTime.now())
                .startDate(LocalDate.now())
                .endDate(LocalDate.now())
                .build();

        // Mock
        when(customerMapper.toCustomerEntity(customerItem)).thenReturn(getCustomerEntity());
        when(bookMapper.toBookEntity(bookItem)).thenReturn(getBookEntity());

        // Perform
        BorrowPeriodEntity borrowPeriodEntity = borrowPeriodMapper.toBorrowPeriodEntity(borrowPeriodItem);

        // Verify
        assertThat(borrowPeriodEntity.getId()).isEqualTo(borrowPeriodItem.getId());
        assertThat(borrowPeriodEntity.getCustomer().getId()).isEqualTo(borrowPeriodItem.getCustomer().getId());
        assertThat(borrowPeriodEntity.getBook().getId()).isEqualTo(borrowPeriodItem.getBook().getId());
        assertThat(borrowPeriodEntity.getStatus()).isEqualTo(borrowPeriodItem.getStatus());
        assertThat(borrowPeriodEntity.getCreationDateAndTime()).isEqualTo(borrowPeriodItem.getCreationDateAndTime());
        assertThat(borrowPeriodEntity.getStartDate()).isEqualTo(borrowPeriodItem.getStartDate());
        assertThat(borrowPeriodEntity.getEndDate()).isEqualTo(borrowPeriodItem.getEndDate());
    }


    // Helper Methods

    private CustomerEntity getCustomerEntity() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(6L);
        customerEntity.setFirstName("Test");
        customerEntity.setLastName("Customer");
        customerEntity.setAge(23);
        customerEntity.setAddress("Test Address");
        customerEntity.setPhone("232323232");
        customerEntity.setEmail("testemail@gmail.com");
        customerEntity.setDateAndTimeOfRegistration(LocalDateTime.now());
        return customerEntity;
    }

    private CustomerItem getCustomerItem() {
        return new CustomerItem.Builder()
                .id(6L)
                .firstName("Test")
                .lastName("Customer")
                .age(23)
                .address("Test Address")
                .phone("232323232")
                .email("testemail@gmail.com")
                .dateAndTimeOfRegistration(LocalDateTime.now())
                .build();
    }

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
