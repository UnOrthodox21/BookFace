package com.rihards.bookface.mappers;

import com.rihards.bookface.entities.BookRequestEntity;
import com.rihards.bookface.entities.BorrowPeriodEntity;
import com.rihards.bookface.entities.CustomerEntity;
import com.rihards.bookface.items.BookRequestItem;
import com.rihards.bookface.items.BorrowPeriodItem;
import com.rihards.bookface.items.CustomerItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    private final BorrowPeriodMapper borrowPeriodMapper;
    private final BookRequestMapper bookRequestMapper;

    @Autowired
    public CustomerMapper(@Lazy BorrowPeriodMapper borrowPeriodMapper, @Lazy BookRequestMapper bookRequestMapper) {
        this.borrowPeriodMapper = borrowPeriodMapper;
        this.bookRequestMapper = bookRequestMapper;
    }

    public CustomerItem toCustomerItem(CustomerEntity customerEntity) {

        if (customerEntity == null) {
            return null;
        }

        List<BorrowPeriodEntity> borrowPeriodEntityList = customerEntity.getBorrowPeriods();
        List<BorrowPeriodItem> borrowPeriodItemList = borrowPeriodEntityList.stream()
                .map(borrowPeriodEntity -> borrowPeriodMapper.toBorrowPeriodItem(borrowPeriodEntity))
                .collect(Collectors.toList());;

        List<BookRequestEntity> bookRequestEntityList = customerEntity.getBookRequests();
        List<BookRequestItem> bookRequestItemList = bookRequestEntityList.stream()
                .map(bookRequsetEntity -> bookRequestMapper.toBookRequestItem(bookRequsetEntity))
                .collect(Collectors.toList());;

        return new CustomerItem.Builder()
                .firstName(customerEntity.getFirstName())
                .lastName(customerEntity.getLastName())
                .age(customerEntity.getAge())
                .address(customerEntity.getAddress())
                .phone(customerEntity.getPhone())
                .email(customerEntity.getEmail())
                .dateAndTimeOfRegistration(customerEntity.getDateOfRegistration())
                .borrowPeriods(borrowPeriodItemList)
                .bookRequests(bookRequestItemList)
                .build();
    }


    public CustomerEntity toCustomerEntity(CustomerItem customerItem) {

        if (customerItem == null) {
            return null;
        }

        List<BorrowPeriodItem> borrowPeriodItemList = customerItem.getBorrowPeriods();
        List<BorrowPeriodEntity> borrowPeriodEntityList = borrowPeriodItemList.stream()
                .map(borrowPeriodItem -> borrowPeriodMapper.toBorrowPeriodEntity(borrowPeriodItem))
                .collect(Collectors.toList());;

        List<BookRequestItem> bookRequestItemList = customerItem.getBookRequests();
        List<BookRequestEntity> bookRequestEntityList = bookRequestItemList.stream()
                .map(bookRequestItem -> bookRequestMapper.toBookRequestEntity(bookRequestItem))
                .collect(Collectors.toList());;

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setFirstName(customerItem.getFirstName());
        customerEntity.setLastName(customerItem.getLastName());
        customerEntity.setAge(customerItem.getAge());
        customerEntity.setAddress(customerItem.getAddress());
        customerEntity.setPhone(customerItem.getPhone());
        customerEntity.setEmail(customerItem.getEmail());
        customerEntity.setDateAndTimeOfRegistration(customerItem.getDateAndTimeOfRegistration());
        customerEntity.setBorrowPeriods(borrowPeriodEntityList);
        customerEntity.setBookRequests(bookRequestEntityList);

        return customerEntity;
    }

}
