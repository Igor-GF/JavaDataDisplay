//package com.example.JavaDataDisplay.controllers;
//import com.example.JavaDataDisplay.dataAcces.CustomerRepository;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class APICustomerController {
//    // We pass all the work to the repository
//    private CustomerRepository customerRepository = new CustomerRepository();
//
//
//    @GetMapping("/customers")
//    public String getAllCustomers(Model model){
//        model.addAttribute("customers", customerRepository.getAllCustomers());
//        return "view-customers";
//    }


/*    @RequestMapping(value = "/api/customers", method = RequestMethod.GET)
    public String getAllCustomers() {
        return "view-customers";
    }*/
//}