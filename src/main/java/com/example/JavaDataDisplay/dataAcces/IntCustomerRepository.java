package com.example.JavaDataDisplay.dataAcces;

import com.example.JavaDataDisplay.models.Customer;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public interface IntCustomerRepository {
    public ArrayList<Customer> getAllCustomers();
    public Customer customerById();
    public Customer customerByName();
    public ArrayList<Customer> getCustomersBySelection();
    public Customer addNewCustomer();
    public Customer updateExistingCustomer();
    public int returnNumberCustomersCountry();
    public ArrayList<Customer> getHighestSpendingCustomers();
    public ArrayList<Customer> mostPopularGenreCustomer();
}
