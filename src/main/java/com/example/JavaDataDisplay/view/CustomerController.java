package com.example.JavaDataDisplay.view;

import com.example.JavaDataDisplay.dataAcces.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    private CustomerRepository customerRepository = new CustomerRepository();

    @GetMapping("/customers")
    public String getAllCustomers(Model model){
        model.addAttribute("customers", customerRepository.getAllCustomers());
        return "view-customers";
    }

    @GetMapping("/customers/{custId}")
    public String getCustomerById(Model model){
        model.addAttribute("customerById", customerRepository.getCustomerById("custId"));
        return "view-customer-by-id";
    }

    @GetMapping("/customers/name/{custName}")
    public String getCustomerByName(Model model){
        model.addAttribute("customerByName", customerRepository.getCustomerByName("custName"));
        return "view-customer-by-name";
    }
}
