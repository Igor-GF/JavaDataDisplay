package com.example.JavaDataDisplay.dataAcces;
import com.example.JavaDataDisplay.models.Customer;
import com.example.JavaDataDisplay.models.CustomerCountry;
import com.example.JavaDataDisplay.models.CustomerSpender;
import org.springframework.stereotype.Service;
import java.sql.*;
import java.util.ArrayList;

@Service
public class CustomerRepository {
    private String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;
    public ArrayList<Customer> customers = new ArrayList<Customer>();
    public ArrayList<CustomerCountry> customersCountry = new ArrayList<CustomerCountry>();
    public ArrayList<CustomerSpender> customersSpender = new ArrayList<CustomerSpender>();

    public ArrayList<Customer> getAllCustomers() {
        customers.clear();
        try {
            // Connect to the database
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established 1.");

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

    public Customer getCustomerById(String custId) {
        Customer customer = null;
        try {
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established 2.");
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
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            // exit the program
            System.exit(-1);
        }
        return customer;
    }

    public Customer getCustomerByName(String custName) {
        Customer customer = null;
        try {
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established 3.");
            // Make SQL query
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM Customer WHERE FirstName = ?");
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
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            // exit the program
            System.exit(-1);
        }
        return customer;
    }

    // Note that this does not completely work. The limit and offset could not be implemented.
    public ArrayList<Customer> getCustomersBySelection(int limit, int offset) {
        customers.clear();
        try {
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established 3.");
            // Make SQL query
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM Customer WHERE CustomerId BETWEEN 50 AND 60");
            //preparedStatement.setInt(1, limit);
            //preparedStatement.setInt(2, offset);
            // Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customers.add(new Customer(
                        resultSet.getString("CustomerId"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Country"),
                        resultSet.getString("PostalCode"),
                        resultSet.getString("Phone"),
                        resultSet.getString("Email")
                ));
            }
            System.out.println("Select specific customer successful");
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            // exit the program
            System.exit(-1);
        }
        return customers;
    }

    // Note that this does not completely work. It does not create a new Customer.
    public Boolean addCustomer(Customer customer){
        Boolean success = false;
        try{
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established to addCustomer.");

            // Make SQL query
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Customer(CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email) VALUES(?,?,?,?,?,?,?)");
            preparedStatement.setString(1,customer.getCustomerId());
            preparedStatement.setString(2,customer.getFirstName());
            preparedStatement.setString(3,customer.getLastName());
            preparedStatement.setString(4,customer.getCountry());
            preparedStatement.setString(5,customer.getPostalCode());
            preparedStatement.setString(6,customer.getPhoneNumber());
            preparedStatement.setString(7,customer.getEmail());
            // Execute Query
            int result = preparedStatement.executeUpdate();
            success = (result != 0);
            System.out.println("Add customer successful");
        }
        catch (Exception exception){
            System.out.println(exception.toString());
        }
        finally {
            try {
                conn.close();
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
        return success;
    }

    // Note that this does not completely work. It does not update.
    public int updateExistingCustomer (Customer customer) {
        try {
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");

            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE Customer SET CustomerId = ?, FirstName = ?, LastName = ?, Country = ?, PostalCode = ?, Phone = ?, Email = ? WHERE Id = ?");
            preparedStatement.setString(1,customer.getCustomerId());
            preparedStatement.setString(2,customer.getFirstName());
            preparedStatement.setString(3,customer.getLastName());
            preparedStatement.setString(4,customer.getCountry());
            preparedStatement.setString(5,customer.getPostalCode());
            preparedStatement.setString(6,customer.getPhoneNumber());
            preparedStatement.setString(7,customer.getEmail());
            return preparedStatement.executeUpdate();

        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return 0;
        }
    }

    // Note that this does not completely work.
    public ArrayList<CustomerCountry> returnNumberCustomersCountry() {
        customersCountry.clear();
        ResultSet resultSet = null;
        try {
            // Connect to the database
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established to getCustomerByCountry.");

            // Make SQL query
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT Country, COUNT(CustomerId) AS totalCustomers FROM Customer GROUP BY Country ORDER BY totalCustomers DESC");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customersCountry.add(
                        new CustomerCountry(
                                resultSet.getString("Country"),
                                resultSet.getInt("totalCustomers")
                        )
                );
            }
            System.out.println("Selected all the customers");

        } catch (SQLException sqe) {
            sqe.printStackTrace();
            // exit the program
            System.exit(-1);
        }
        return customersCountry;
    }

    public ArrayList<CustomerSpender> getHighestSpendingCustomers(){
        customersSpender.clear();
        ResultSet resultSet = null;
        try {
            // Connect to the database
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established to getHighestSpendingCustomers.");

            // Make SQL query
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT CustomerId, SUM(Total) AS SumOfTotal FROM Invoice GROUP BY CustomerId ORDER BY SumOfTotal DESC");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customersSpender.add(
                    new CustomerSpender(
                        resultSet.getInt("CustomerId"),
                        resultSet.getDouble("SumOfTotal")
                    )
                );
            }
            System.out.println("Selected all the spending customers");

        } catch (SQLException sqe) {
            sqe.printStackTrace();
            // exit the program
            System.exit(-1);
        }
        return customersSpender;
    }

    public ResultSet mostPopularGenreCustomer(){
        ResultSet resultset = null;
        try {
            // Connect to the database
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established 1.");

            // Make SQL query
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT MAX(InvoiceId) AS LargestPrice FROM Products;");
            resultset = preparedStatement.executeQuery();

            System.out.println("Selected all the spending customers");

        } catch (SQLException sqe) {
            sqe.printStackTrace();
            // exit the program
            System.exit(-1);
        }
        return resultset;
    }

    public ArrayList<Customer> getRandomCustomers() {
        customers.clear();
        try {
            // Connect to the database
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established for getRandomCustomers.");

            // Make SQL query
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Customer ORDER BY random() LIMIT 5");
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
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            // exit the program
            System.exit(-1);
        }
        finally {
            try {
                conn.close();
                System.out.println("trying to close connection");
            }
            catch (Exception exception){
                System.out.println("Exception: " + exception);
            }
        }
        return customers;
    }
}