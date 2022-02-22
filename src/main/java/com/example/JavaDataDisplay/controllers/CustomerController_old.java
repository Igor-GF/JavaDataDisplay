package com.example.JavaDataDisplay.controllers;
import com.example.JavaDataDisplay.models.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class CustomerController_old {
    // We pass all the work to the repository
    private CustomerRepository customerRepository = new CustomerRepository();

    @RequestMapping(value = "/api/customers", method = RequestMethod.GET)
    public ArrayList<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    /*
  This returns a specific customer, based on a given Id.
  We use a query string here to extract the Id.
  E.g. api/customer?id=ALFKI
  Seen as a BAD practice
*/

    @RequestMapping(value = "api/customer", method = RequestMethod.GET)
    public Customer getCustomerByQueryId(@RequestParam(value="id", defaultValue = "ALFKI") String id){
        return customerRepository.getCustomerById(id);
    }

    /*
  This returns a specific customer, based on a given Id.
  We use a header here to extract the Id.
*/

    @RequestMapping(value = "api/customerheader", method = RequestMethod.GET)
    public Customer getCustomerByHeaderId(@RequestHeader("id") String id){
        return customerRepository.getCustomerById(id);
    }

    /*
  This returns a specific customer, based on a given Id.
  We use a path variable here to extract the Id.
*/

    @RequestMapping(value = "api/customers/{id}", method = RequestMethod.GET)
    public Customer getCustomerByPathId(@PathVariable String id){
        return customerRepository.getCustomerById(id);
    }

    /*
  This adds a new customer.
  It takes the new customer from the body of the request.
*/

    @RequestMapping(value = "api/customers", method = RequestMethod.POST)
    public Boolean addNewCustomer(@RequestBody Customer customer){
        return customerRepository.addCustomer(customer);
    }

    /*
  This updates an existing customer.
  It takes the new customer data from the body of the request.
  As well as taking the Id of the customer from the path variables, this is
  to do a check if the body matches the id. Just a layer of saftey.
*/

    @RequestMapping(value = "api/customers/{id}", method = RequestMethod.PUT)
    public Boolean updateExistingCustomer(@PathVariable String id, @RequestBody Customer customer){
        return customerRepository.updateCustomer(customer);
    }



}