package com.example.JavaDataDisplay.dataAcces;
import com.example.JavaDataDisplay.models.Customer;
import java.sql.*;
import java.util.ArrayList;


public class CustomerRepository {
    private String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;
    public ArrayList<Customer> customers = new ArrayList<Customer>();

    public ArrayList<Customer> getAllCustomers() {

        try {
            // Connect to the database
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");

            // Make SQL query
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM customer");
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
                ));
            }
            System.out.println("Selected all the customers");
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
            // exit the program
            System.exit(-1);
        }
        return customers;
    }

    public String customerById(){
        return null;
    }


    public String customerByName(){
        return null;
    }

    public ArrayList<Customer> getCustomersBySelection() {
        return null;
    }

    public void addNewCustomer() {
    }

    public void updateExistingCustomer(){

    }

    public void returnNumberCustomersCountry(){

    }

    public void getHighestSpendingCustomers(){

    }

    public void mostPopularGenreCustomer(){

    }


}