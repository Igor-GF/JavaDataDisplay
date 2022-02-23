//package com.example.JavaDataDisplay.controllers;
//import com.example.JavaDataDisplay.dataAcces.CustomerRepository;
//import com.example.JavaDataDisplay.models.Customer;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//
//@RestController
//public class APICustomerController {
//    // We pass all the work to the repository
//    private CustomerRepository customerRepository = new CustomerRepository();
//
//
//    @GetMapping("/customers")
//    public ArrayList<Customer> getAllCustomers(){
//        return customerRepository.getAllCustomers();
//    }
//
//
///*    @RequestMapping(value = "/api/customers", method = RequestMethod.GET)
//    public String getAllCustomers() {
//        return "view-customers";
//    }*/
//}