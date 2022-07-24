package com.rihards.bookface.mappers;

import com.rihards.bookface.entities.CustomerEntity;
import com.rihards.bookface.items.CustomerItem;

import org.springframework.stereotype.Component;


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
                .dateAndTimeOfRegistration(customerEntity.getDateAndTimeOfRegistration())
                .build();
    }


    public CustomerEntity toCustomerEntity(CustomerItem customerItem) {

        if (customerItem == null) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setId(customerItem.getId());
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
