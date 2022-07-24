package com.rihards.bookface.services;

import com.rihards.bookface.entities.CustomerEntity;
import com.rihards.bookface.items.CustomerItem;
import com.rihards.bookface.mappers.CustomerMapper;
import com.rihards.bookface.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerMapper customerMapper;

    @InjectMocks
    CustomerService customerService;

    CustomerEntity customerEntity = new CustomerEntity();
    CustomerItem customerItem = new CustomerItem.Builder().build();


    @BeforeEach
    public void setup() {
        customerEntity = getCustomerEntity();
        customerItem = getCustomerItem();
    }

    @Test
    void testGetAllCustomers() {

        List<CustomerEntity> customerEntityList = new ArrayList<CustomerEntity>();
        customerEntityList.add(customerEntity);

        // Mock
        when(customerRepository.findAll()).thenReturn(customerEntityList);
        when(customerMapper.toCustomerEntity(customerItem)).thenReturn(customerEntity);
        when(customerMapper.toCustomerItem(customerEntity)).thenReturn(customerItem);

        // Perform
        List<CustomerItem> foundCustomerItemList = customerService.getAllCustomers();
        CustomerItem firstFoundCustomerItem = foundCustomerItemList.get(0);

        // Assert
        assert (foundCustomerItemList.size() == 1);
        assert (firstFoundCustomerItem.getId() == customerItem.getId());
        assert (firstFoundCustomerItem.getFirstName()).equals(customerItem.getFirstName());
        assert (firstFoundCustomerItem.getLastName()).equals(customerItem.getLastName());
        assert (firstFoundCustomerItem.getEmail()).equals(customerItem.getEmail());
        assert (firstFoundCustomerItem.getAddress()).equals(customerItem.getAddress());
        assert (firstFoundCustomerItem.getPhone()).equals(customerItem.getPhone());
        assert (firstFoundCustomerItem.getAge() == customerItem.getAge());
        assert (firstFoundCustomerItem.getDateAndTimeOfRegistration()).equals(customerItem.getDateAndTimeOfRegistration());

    }

    @Test
    void testGetCustomerByCustomerId() {

        // Mock
        when(customerRepository.findById(customerEntity.getId())).thenReturn(Optional.of(customerEntity));
        when(customerMapper.toCustomerEntity(customerItem)).thenReturn(customerEntity);
        when(customerMapper.toCustomerItem(customerEntity)).thenReturn(customerItem);

        // Perform
        Optional<CustomerItem> foundCustomerItem = customerService.getCustomerByCustomerId(customerEntity.getId());

        // Assert
        assert (foundCustomerItem.get().getId() == customerItem.getId());
        assert (foundCustomerItem.get().getEmail()).equals(customerItem.getEmail());
        assert (foundCustomerItem.get().getPhone()).equals(customerItem.getPhone());
        assert (foundCustomerItem.get().getAddress()).equals(customerItem.getAddress());
        assert (foundCustomerItem.get().getEmail()).equals(customerItem.getEmail());
        assert (foundCustomerItem.get().getFirstName()).equals(customerItem.getFirstName());
        assert (foundCustomerItem.get().getLastName()).equals(customerItem.getLastName());
        assert (foundCustomerItem.get().getAge() == customerItem.getAge());
        assert (foundCustomerItem.get().getDateAndTimeOfRegistration()).equals(customerItem.getDateAndTimeOfRegistration());

        // Verify
        verify(customerRepository, times(1)).findById(customerEntity.getId());

    }

    @Test
    void testCreateCustomer() {

        // Mock
        when(customerRepository.save(customerEntity)).thenReturn(customerEntity);
        when(customerMapper.toCustomerEntity(customerItem)).thenReturn(customerEntity);
        when(customerMapper.toCustomerItem(customerEntity)).thenReturn(customerItem);

        // Perform
        CustomerItem createdCustomerItem = customerService.createCustomer(customerItem);

        // Assert
        assert (createdCustomerItem.getFirstName()).equals(customerItem.getFirstName());

        // Verify
        verify(customerRepository, times(1)).save(customerEntity);

    }

    @Test
    void testDeleteCustomerById() {

        // Perform
        customerService.deleteCustomerById(customerEntity.getId());

        // Verify
        verify(customerRepository, times(1)).deleteById(customerEntity.getId());

    }

    @Test
    void testUpdateCustomerById() {
        // Mock
        when(customerRepository.findById(customerEntity.getId())).thenReturn(Optional.of(customerEntity));
        when(customerRepository.save(customerEntity)).thenReturn(customerEntity);
        when(customerMapper.toCustomerEntity(customerItem)).thenReturn(customerEntity);
        when(customerMapper.toCustomerItem(customerEntity)).thenReturn(customerItem);

        // Perform
        CustomerItem updatedCustomerItem = customerService.updateCustomerById(customerItem.getId(), customerItem);

        // Assert
        assert (updatedCustomerItem.getFirstName()).equals(customerItem.getFirstName());

        // Verify
        verify(customerRepository, times(1)).save(customerEntity);

    }

    // Helper functions

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
