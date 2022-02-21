package com.example.JavaDataDisplay.controllers;

// This controller can be used to control the date from the database.
// Only two example methods are created here
// Note that it interacts with the html file: resources/templates/view-customer.html

@Controller
public class CustomerController {
 /*
  "GET /"
  "GET /customers"
 */

    CustomerRepository crep = new CustomerRepository();
    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/customers")
    public String getAllCustomers(Model model){
        model.addAttribute("customers", crep.getAllCustomers());
        return "view-customers";
    }
