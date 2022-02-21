package com.example.JavaDataDisplay.controllers;
import com.example.JavaDataDisplay.models.Customer;
import java.sql.*;
import java.util.ArrayList;

public class CustomerRepository {
    private String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;

    public Customer getCustomerById(String custId){
        Customer customer = null;
        try{
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");

            // Make SQL query
            PreparedStatement preparedStatement =
                conn.prepareStatement("SELECT CustomerId,FirstName, LastName, Country, PostalCode, Phone, Email FROM customer WHERE CustomerId = ?");
            preparedStatement.setString(1,custId);
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
        catch (SQLException sqlex){
            sqlex.printStackTrace();
            // exit the program
            System.exit(-1);
        }
        finally {
            try {
                conn.close();
            }
            catch (SQLException sqlex){
                sqlex.printStackTrace();
                // exit the program
                System.exit(-1);
            }
        }
        return customer;
    }


    public Boolean addCustomer(Customer customer){
        Boolean success = false;
        try{
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");

            // Make SQL query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("INSERT INTO customer(CustomerId,FirstName, LastName, Country, PostalCode, Phone, Email) VALUES(?,?,?,?,?,?,?)");
            preparedStatement.setString(1,customer.getCustomerId());
            preparedStatement.setString(2,customer.getFirstName());
            preparedStatement.setString(3,customer.getLastName());
            preparedStatement.setString(4,customer.getCounty());
            preparedStatement.setString(5,customer.getPostalCode());
            preparedStatement.setString(6,customer.getPhoneNumber());
            preparedStatement.setString(7,customer.getEmail());

            // Execute Query
            int result = preparedStatement.executeUpdate();
            success = (result != 0);
            System.out.println("Add customer successful");
        }
        catch (SQLException sqlex){
            sqlex.printStackTrace();
            // exit the program
            System.exit(-1);
        }
        finally {
            try {
                conn.close();
            }
            catch (SQLException sqlex){
                sqlex.printStackTrace();
                // exit the program
                System.exit(-1);
            }
        return success;
        }
    }

    public ArrayList<Customer> getAllCustomers() {
        System.out.println("Do not forget to fill this in later");
        return null;
    }

    public Boolean updateCustomer(Customer customer) {
        System.out.println("Do not forget to fill this in later. :D");
        return null;
    }
}
