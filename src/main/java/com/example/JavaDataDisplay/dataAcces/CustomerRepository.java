package com.example.JavaDataDisplay.dataAcces;
import com.example.JavaDataDisplay.models.Customer;
import org.springframework.stereotype.Service;
import java.sql.*;
import java.util.ArrayList;

@Service
public class CustomerRepository{
    private String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;
    public ArrayList<Customer> customers = new ArrayList<Customer>();

    public ArrayList<Customer> getAllCustomers() {

        try {
            // Connect to the database
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");

            // Make SQL query
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Customer");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customers.add(
                    new Customer(
                        resultSet.getString("CustomerId"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Country"),
                        resultSet.getString("PostalCode"),
                        resultSet.getString("Phone"),
                        resultSet.getString("Email")
                    )
                );
            }
            System.out.println("Selected all the customers");
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            // exit the program
            System.exit(-1);
        }
        return customers;
    }

    public Customer getCustomerById(String custId){
        Customer customer = null;
        try{
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");
            // Make SQL query
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM Customer WHERE CustomerId = ?");
            preparedStatement.setString(1, custId);
            // Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer(
                        resultSet.getString("CustomerId"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Country"),
                        resultSet.getString("PostalCode"),
                        resultSet.getString("Phone"),
                        resultSet.getString("Email")
                );
            }
            System.out.println("Select specific customer successful");
        }
        catch (SQLException sqe) {
            sqe.printStackTrace();
            // exit the program
            System.exit(-1);
        }
        return customer;
    }

    public Customer customerByName(String custName){
        Customer customer = null;
        try{
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");
            // Make SQL query
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM Customer WHERE FirstName LIKE '?%'");
            preparedStatement.setString(1, custName);
            // Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer(
                        resultSet.getString("CustomerId"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Country"),
                        resultSet.getString("PostalCode"),
                        resultSet.getString("Phone"),
                        resultSet.getString("Email")
                );
            }
            System.out.println("Select specific customer successful");
        }
        catch (SQLException sqe) {
            sqe.printStackTrace();
            // exit the program
            System.exit(-1);
        }
        return customer;
    }

    public ArrayList<Customer> getCustomersBySelection() {
        return null;
    }

    public Customer addNewCustomer() {
        return null;
    }

    public Customer updateExistingCustomer(){
        return null;
    }

    public int returnNumberCustomersCountry(){
        return 0;
    }

    public ArrayList<Customer> getHighestSpendingCustomers(){
        return null;
    }

    public ArrayList<Customer> mostPopularGenreCustomer(){
        return null;
    }


}