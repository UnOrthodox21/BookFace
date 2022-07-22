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

    public CustomerItem toCustomerItem(CustomerEntity customerEntity) {

        if (customerEntity == null) {
            return null;
        }


        return new CustomerItem.Builder()
                .id(customerEntity.getId())
                .firstName(customerEntity.getFirstName())
                .lastName(customerEntity.getLastName())
                .age(customerEntity.getAge())
                .address(customerEntity.getAddress())
                .phone(customerEntity.getPhone())
                .email(customerEntity.getEmail())
                .dateAndTimeOfRegistration(customerEntity.getDateOfRegistration())
                .build();
    }


    public CustomerEntity toCustomerEntity(CustomerItem customerItem) {

        if (customerItem == null) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setFirstName(customerItem.getFirstName());
        customerEntity.setLastName(customerItem.getLastName());
        customerEntity.setAge(customerItem.getAge());
        customerEntity.setAddress(customerItem.getAddress());
        customerEntity.setPhone(customerItem.getPhone());
        customerEntity.setEmail(customerItem.getEmail());
        customerEntity.setDateAndTimeOfRegistration(customerItem.getDateAndTimeOfRegistration());

        return customerEntity;
    }

}
