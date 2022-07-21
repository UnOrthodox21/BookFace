package com.rihards.bookface.mappers;

import com.rihards.bookface.entities.BookEntity;
import com.rihards.bookface.entities.BorrowPeriodEntity;
import com.rihards.bookface.entities.CustomerEntity;
import com.rihards.bookface.items.BookItem;
import com.rihards.bookface.items.BorrowPeriodItem;
import com.rihards.bookface.items.CustomerItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class BorrowPeriodMapper {

    private final CustomerMapper customerMapper;
    private final BookMapper bookMapper;

    @Autowired
    public BorrowPeriodMapper(@Lazy CustomerMapper customerMapper, @Lazy BookMapper bookMapper) {
        this.customerMapper = customerMapper;
        this.bookMapper = bookMapper;
    }

    public BorrowPeriodItem toBorrowPeriodItem(BorrowPeriodEntity borrowPeriodEntity) {

        if (borrowPeriodEntity == null) {
            return null;
        }

        CustomerEntity customerEntity = borrowPeriodEntity.getCustomer();
        CustomerItem customerItem = customerMapper.toCustomerItem(customerEntity);

        BookEntity bookEntity = borrowPeriodEntity.getBook();
        BookItem bookItem = bookMapper.toBookItem(bookEntity);

        return new BorrowPeriodItem.Builder()
                .customer(customerItem)
                .book(bookItem)
                .status(borrowPeriodEntity.getStatus())
                .creationDateAndTime(borrowPeriodEntity.getCreationDateAndTime())
                .startDate(borrowPeriodEntity.getStartDate())
                .endDate(borrowPeriodEntity.getEndDate())
                .build();
    }


    public BorrowPeriodEntity toBorrowPeriodEntity(BorrowPeriodItem borrowPeriodItem) {

        if (borrowPeriodItem == null) {
            return null;
        }

        CustomerItem customerItem = borrowPeriodItem.getCustomer();
        CustomerEntity customerEntity = customerMapper.toCustomerEntity(customerItem);

        BookItem bookItem = borrowPeriodItem.getBook();
        BookEntity bookEntity = bookMapper.toBookEntity(bookItem);

        BorrowPeriodEntity borrowPeriodEntity = new BorrowPeriodEntity();

        borrowPeriodEntity.setCustomer(customerEntity);
        borrowPeriodEntity.setBook(bookEntity);
        borrowPeriodEntity.setStatus(borrowPeriodItem.getStatus());
        borrowPeriodEntity.setCreationDateAndTime(borrowPeriodItem.getCreationDateAndTime());
        borrowPeriodEntity.setStartDate(borrowPeriodItem.getStartDate());
        borrowPeriodEntity.setEndDate(borrowPeriodItem.getEndDate());

        return borrowPeriodEntity;
    }

}
