package com.example.JavaDataDisplay.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// Deze nog in orde maken.
@Controller
public class HomeController {
    @GetMapping("/customers")
    public String getAllCustomers(Model model){
        model.addAttribute("customers", customerRepository.getAllCustomers());
        return "view-customers";
    }
}