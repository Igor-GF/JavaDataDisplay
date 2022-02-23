package com.example.JavaDataDisplay.controllers;
import com.example.JavaDataDisplay.dataAcces.CustomerRepository;
import com.example.JavaDataDisplay.models.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class APICustomerController {
    // We pass all the work to the repository
    private CustomerRepository customerRepository = new CustomerRepository();

    @GetMapping("/customers")
    public ArrayList<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }

    @GetMapping("/customers/id/{customerId}")
    public Customer getCustomerById (@PathVariable String customerId){
        return customerRepository.getCustomerById(customerId);
    }

    @GetMapping("/customers/name/{customerName}")
    public Customer getCustomerByName (@PathVariable String customerName){
        return customerRepository.getCustomerByName(customerName);
    }

}