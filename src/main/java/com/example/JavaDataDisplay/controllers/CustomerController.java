package com.example.JavaDataDisplay.controllers;
import com.example.JavaDataDisplay.models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CustomerController {
 /*
  "GET /"
  "GET /customers"
 */

    CustomerRepository crep = new CustomerRepository();

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/customers")
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", crep.getAllCustomers());
        return "view-customers_old";
    }

    @GetMapping("/customers/register")
    public String showAddCustomer(Model model){
        model.addAttribute("customer", new Customer("","","","","","",""));
        return "add-customers";
    }

    @PostMapping("/customers/register")
    public String handleAddCustomer(@ModelAttribute Customer customer, BindingResult errors, Model model){
        boolean success = crep.addCustomer(customer);
        if(success){
            model.addAttribute("customer", new Customer("","","","","","",""));
        } else {
            model.addAttribute("customer", customer);
        }
        model.addAttribute("success", success);
        return "add-customers";
    }

}
