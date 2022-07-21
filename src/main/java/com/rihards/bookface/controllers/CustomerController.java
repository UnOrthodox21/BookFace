package com.rihards.bookface.controllers;

import com.rihards.bookface.items.CustomerItem;
import com.rihards.bookface.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookface/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerItem> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    public Optional<CustomerItem> getCustomerByCustomerId(@PathVariable("customerId") long customerId) {
        return customerService.getCustomerByCustomerId(customerId);
    }

    @PostMapping
    public CustomerItem createCustomer(@RequestBody CustomerItem customerItem) {
        return customerService.createCustomer(customerItem);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomerById(@PathVariable("customerId") long customerId) {
        customerService.deleteCustomerById(customerId);
    }

    @PutMapping("/{customerId}")
    public CustomerItem updateCustomerById(@RequestBody CustomerItem customerItem, @PathVariable("customerId") long customerId) {
        return customerService.updateCustomerById(customerId, customerItem);
    }


}
