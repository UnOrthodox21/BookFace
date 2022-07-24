package com.rihards.bookface.mappers;

import com.rihards.bookface.entities.CustomerEntity;
import com.rihards.bookface.items.CustomerItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class CustomerMapperTest {

    private CustomerMapper customerMapper = new CustomerMapper();

    @Test
    void testToCustomerItem() {

        // Setup
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(6L);
        customerEntity.setFirstName("Test");
        customerEntity.setLastName("Customer");
        customerEntity.setAge(23);
        customerEntity.setAddress("Test Address");
        customerEntity.setPhone("232323232");
        customerEntity.setEmail("testemail@gmail.com");
        customerEntity.setDateAndTimeOfRegistration(LocalDateTime.now());

        // Perform
        CustomerItem customerItem = customerMapper.toCustomerItem(customerEntity);

        // Verify
        assertThat(customerItem.getId()).isEqualTo(customerEntity.getId());
        assertThat(customerItem.getFirstName()).isEqualTo(customerEntity.getFirstName());
        assertThat(customerItem.getLastName()).isEqualTo(customerEntity.getLastName());
        assertThat(customerItem.getAge()).isEqualTo(customerEntity.getAge());
        assertThat(customerItem.getAddress()).isEqualTo(customerEntity.getAddress());
        assertThat(customerItem.getPhone()).isEqualTo(customerEntity.getPhone());
        assertThat(customerItem.getEmail()).isEqualTo(customerEntity.getEmail());
        assertThat(customerItem.getDateAndTimeOfRegistration()).isEqualTo(customerEntity.getDateAndTimeOfRegistration());
    }

    @Test
    void testToCustomerEntity() {

        // Setup
        CustomerItem customerItem = new CustomerItem.Builder()
                .id(6L)
                .firstName("Test")
                .lastName("Customer")
                .age(23)
                .address("Test Address")
                .phone("232323232")
                .email("testemail@gmail.com")
                .dateAndTimeOfRegistration(LocalDateTime.now())
                .build();

        // Perform
        CustomerEntity customerEntity = customerMapper.toCustomerEntity(customerItem);


        // Verify
        assertThat(customerEntity.getId()).isEqualTo(customerItem.getId());
        assertThat(customerEntity.getFirstName()).isEqualTo(customerItem.getFirstName());
        assertThat(customerEntity.getLastName()).isEqualTo(customerItem.getLastName());
        assertThat(customerEntity.getAge()).isEqualTo(customerItem.getAge());
        assertThat(customerEntity.getAddress()).isEqualTo(customerItem.getAddress());
        assertThat(customerEntity.getPhone()).isEqualTo(customerItem.getPhone());
        assertThat(customerEntity.getEmail()).isEqualTo(customerItem.getEmail());
        assertThat(customerEntity.getDateAndTimeOfRegistration()).isEqualTo(customerItem.getDateAndTimeOfRegistration());

    }


}
