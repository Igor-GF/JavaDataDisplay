package com.example.JavaDataDisplay.view;

import com.example.JavaDataDisplay.dataAcces.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    private CustomerRepository customerRepository = new CustomerRepository();

    @GetMapping("/api/home")
    public String getRandomData(Model model){
        model.addAttribute("data", customerRepository.getRandomData());
        return "view-random-customers";
    }

    @GetMapping("/api/home/search")
    public String searchCustomers(Model model){
        model.addAttribute("customers", customerRepository.searchCustomers());
        return "view-search";
    }
}
