package com.example.JavaDataDisplay.controllers;
import com.example.JavaDataDisplay.dataAcces.CustomerRepository;
import com.example.JavaDataDisplay.models.Customer;
import com.example.JavaDataDisplay.models.CustomerCountry;
import com.example.JavaDataDisplay.models.CustomerSpender;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
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

    // Method below does not work yet. Check later.
    @GetMapping("/customers/between")
    public ArrayList<Customer> getCustomersBySelection (@RequestParam(value = "limit", defaultValue = "60") String limit,
                                                        @RequestParam(value = "offset", defaultValue = "0") String offset)
            {
        return customerRepository.getCustomersBySelection(
                Integer.parseInt(limit), Integer.parseInt(offset));
    }

    @PostMapping(value = "/customers")
    public Boolean addCustomer(@RequestBody Customer customer){
        return customerRepository.addCustomer(customer);
    }

    @RequestMapping(value = "customers/update/{id}", method = RequestMethod.PUT)
    public int updateExistingCustomer(@PathVariable String id, @RequestBody Customer customer){
        return customerRepository.updateExistingCustomer(customer);
    }

    @GetMapping("/customers/byCountry")
    public ArrayList<CustomerCountry> returnNumberCustomersCountry(){
        return customerRepository.returnNumberCustomersCountry();
    }

    @GetMapping("/invoice/highestSpenders")
    public ArrayList<CustomerSpender> getHighestSpendingCustomers(){
        return customerRepository.getHighestSpendingCustomers();
    }

    @GetMapping("/invoice/mostPopular")
    public ResultSet mostPopularGenreCustomer(){
        return customerRepository.mostPopularGenreCustomer();
    }

}