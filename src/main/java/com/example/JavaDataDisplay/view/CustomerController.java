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
}
