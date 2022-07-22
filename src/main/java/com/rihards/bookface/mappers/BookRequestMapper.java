package com.rihards.bookface.mappers;

import com.rihards.bookface.entities.BookRequestEntity;
import com.rihards.bookface.entities.CustomerEntity;
import com.rihards.bookface.items.BookRequestItem;
import com.rihards.bookface.items.CustomerItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class BookRequestMapper {

    private final CustomerMapper customerMapper;


    @Autowired
    public BookRequestMapper(@Lazy CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    public BookRequestItem toBookRequestItem(BookRequestEntity bookRequestEntity) {

        if (bookRequestEntity == null) {
            return null;
        }

        CustomerEntity customerEntity = bookRequestEntity.getCustomer();
        CustomerItem customerItem = customerMapper.toCustomerItem(customerEntity);


        return new BookRequestItem.Builder()
                .id(bookRequestEntity.getId())
                .customer(customerItem)
                .author(bookRequestEntity.getAuthor())
                .title(bookRequestEntity.getTitle())
                .publishingYear(bookRequestEntity.getPublishingYear())
                .pages(bookRequestEntity.getPages())
                .status(bookRequestEntity.getStatus())
                .creationDateAndTime(bookRequestEntity.getCreationDateAndTime())
                .endDate(bookRequestEntity.getEndDate())
                .build();
    }


    public BookRequestEntity toBookRequestEntity(BookRequestItem bookRequestItem) {

        if (bookRequestItem == null) {
            return null;
        }

        CustomerItem customerItem = bookRequestItem.getCustomer();
        CustomerEntity customerEntity = customerMapper.toCustomerEntity(customerItem);

        BookRequestEntity bookRequestEntity = new BookRequestEntity();

        bookRequestEntity.setCustomer(customerEntity);
        bookRequestEntity.setAuthor(bookRequestItem.getAuthor());
        bookRequestEntity.setTitle(bookRequestItem.getTitle());
        bookRequestEntity.setPublishingYear(bookRequestItem.getPublishingYear());
        bookRequestEntity.setPages(bookRequestItem.getPages());
        bookRequestEntity.setStatus(bookRequestItem.getStatus());
        bookRequestEntity.setCreationDateAndTime(bookRequestItem.getCreationDateAndTime());
        bookRequestEntity.setEndDate(bookRequestItem.getEndDate());

        return bookRequestEntity;
    }


}
