package com.rihards.bookface.mappers;

import com.rihards.bookface.entities.BookRequestEntity;
import com.rihards.bookface.entities.CustomerEntity;
import com.rihards.bookface.items.BookRequestItem;
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
public class BookRequestMapperTest {

    @Mock
    CustomerMapper customerMapper;

    @InjectMocks
    BookRequestMapper bookRequestMapper;

    @Test
    void testToBookRequestItem() {

        // Setup
        CustomerEntity customerEntity = getCustomerEntity();
        BookRequestEntity bookRequestEntity = new BookRequestEntity();

        bookRequestEntity.setId(6L);
        bookRequestEntity.setAuthor("TEST AUTHOR");
        bookRequestEntity.setTitle("TEST BOOK");
        bookRequestEntity.setPublishingYear(1995);
        bookRequestEntity.setPages(321);
        bookRequestEntity.setStatus("TEST STATUS");
        bookRequestEntity.setCustomer(customerEntity);
        bookRequestEntity.setCreationDateAndTime(LocalDateTime.now());
        bookRequestEntity.setEndDate(LocalDate.now());

        // Mock
        when(customerMapper.toCustomerItem(customerEntity)).thenReturn(getCustomerItem());

        // Perform
        BookRequestItem bookRequestItem = bookRequestMapper.toBookRequestItem(bookRequestEntity);

        // Verify
        assertThat(bookRequestItem.getId()).isEqualTo(bookRequestEntity.getId());
        assertThat(bookRequestItem.getCustomer().getId()).isEqualTo(bookRequestEntity.getCustomer().getId());
        assertThat(bookRequestItem.getAuthor()).isEqualTo(bookRequestEntity.getAuthor());
        assertThat(bookRequestItem.getPages()).isEqualTo(bookRequestEntity.getPages());
        assertThat(bookRequestItem.getTitle()).isEqualTo(bookRequestEntity.getTitle());
        assertThat(bookRequestItem.getPublishingYear()).isEqualTo(bookRequestEntity.getPublishingYear());
        assertThat(bookRequestItem.getStatus()).isEqualTo(bookRequestEntity.getStatus());
        assertThat(bookRequestItem.getCreationDateAndTime()).isEqualTo(bookRequestEntity.getCreationDateAndTime());
        assertThat(bookRequestItem.getEndDate()).isEqualTo(bookRequestEntity.getEndDate());
    }

    @Test
    void testToBookRequestEntity() {

        // Setup
        CustomerItem customerItem = getCustomerItem();
        BookRequestItem bookRequestItem = new BookRequestItem
                .Builder()
                .id(6L)
                .author("TEST AUTHOR")
                .title("TEST BOOK")
                .publishingYear(1995)
                .pages(321)
                .status("TEST STATUS")
                .customer(customerItem)
                .creationDateAndTime(LocalDateTime.now())
                .endDate(LocalDate.now())
                .build();

        // Mock
        when(customerMapper.toCustomerEntity(customerItem)).thenReturn(getCustomerEntity());

        // Perform
        BookRequestEntity bookRequestEntity = bookRequestMapper.toBookRequestEntity(bookRequestItem);

        // Verify
        assertThat(bookRequestEntity.getId()).isEqualTo(bookRequestItem.getId());
        assertThat(bookRequestEntity.getCustomer().getId()).isEqualTo(bookRequestItem.getCustomer().getId());
        assertThat(bookRequestEntity.getAuthor()).isEqualTo(bookRequestItem.getAuthor());
        assertThat(bookRequestEntity.getPages()).isEqualTo(bookRequestItem.getPages());
        assertThat(bookRequestEntity.getTitle()).isEqualTo(bookRequestItem.getTitle());
        assertThat(bookRequestEntity.getPublishingYear()).isEqualTo(bookRequestItem.getPublishingYear());
        assertThat(bookRequestEntity.getStatus()).isEqualTo(bookRequestItem.getStatus());
        assertThat(bookRequestEntity.getCreationDateAndTime()).isEqualTo(bookRequestItem.getCreationDateAndTime());
        assertThat(bookRequestEntity.getEndDate()).isEqualTo(bookRequestItem.getEndDate());

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

}


