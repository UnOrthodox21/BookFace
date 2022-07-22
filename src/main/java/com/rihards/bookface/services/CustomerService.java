package com.rihards.bookface.services;

import com.rihards.bookface.entities.BookRequestEntity;
import com.rihards.bookface.entities.BorrowPeriodEntity;
import com.rihards.bookface.entities.CustomerEntity;
import com.rihards.bookface.items.BookRequestItem;
import com.rihards.bookface.items.BorrowPeriodItem;
import com.rihards.bookface.items.CustomerItem;
import com.rihards.bookface.mappers.BookRequestMapper;
import com.rihards.bookface.mappers.BorrowPeriodMapper;
import com.rihards.bookface.mappers.CustomerMapper;
import com.rihards.bookface.repositories.BookRequestRepository;
import com.rihards.bookface.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final BorrowPeriodMapper borrowPeriodMapper;
    private final BookRequestMapper bookRequestMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper,
                           BorrowPeriodMapper borrowPeriodMapper, BookRequestMapper bookRequestMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.borrowPeriodMapper = borrowPeriodMapper;
        this.bookRequestMapper = bookRequestMapper;
    }

    public List<CustomerItem> getAllCustomers() {

        List<CustomerEntity> allCustomerEntities = customerRepository.findAll();

        List<CustomerItem> allCustomerItems =  allCustomerEntities.stream()
                .map(customerEntity -> customerMapper.toCustomerItem(customerEntity))
                .collect(Collectors.toList());

        return allCustomerItems;
    }

    public Optional<CustomerItem> getCustomerByCustomerId(long customerId) {

        Optional<CustomerEntity> foundCustomerEntity = customerRepository.findById(customerId);
        CustomerItem foundCustomerItem = customerMapper.toCustomerItem(foundCustomerEntity.get());
        return Optional.of(foundCustomerItem);
    }

    public CustomerItem createCustomer(CustomerItem customerItem) {
        CustomerEntity customerEntity = customerMapper.toCustomerEntity(customerItem);
        CustomerEntity savedCustomerEntity = customerRepository.save(customerEntity);
        CustomerItem savedCustomerItem = customerMapper.toCustomerItem(savedCustomerEntity);
        return savedCustomerItem;
    }

    public void deleteCustomerById(long customerId) {
        customerRepository.deleteById(customerId);
    }

    public CustomerItem updateCustomerById(long customerId, CustomerItem customerItem) {
        CustomerEntity customertEntityToUpdate = customerRepository.findById(customerId).get();


        if(!customerItem.getFirstName().equals("")) {
            customertEntityToUpdate.setFirstName(customerItem.getFirstName());
        }

        if(!customerItem.getLastName().equals("")) {
            customertEntityToUpdate.setLastName(customerItem.getLastName());
        }

        if(customerItem.getAge() > 0) {
            customertEntityToUpdate.setAge(customerItem.getAge());
        }

        if(!customerItem.getAddress().equals("")) {
            customertEntityToUpdate.setAddress(customerItem.getAddress());
        }

        if(!customerItem.getPhone().equals("")) {
            customertEntityToUpdate.setPhone(customerItem.getPhone());
        }

        if(!customerItem.getEmail().equals("")) {
            customertEntityToUpdate.setEmail(customerItem.getEmail());
        }

        if(customerItem.getDateAndTimeOfRegistration() != null) {
            customertEntityToUpdate.setDateAndTimeOfRegistration(customerItem.getDateAndTimeOfRegistration());
        }


        CustomerEntity savedCustomerEntity = customerRepository.save(customertEntityToUpdate);

        CustomerItem savedCustomerItem = customerMapper.toCustomerItem(savedCustomerEntity);

        return savedCustomerItem;
    }

}
