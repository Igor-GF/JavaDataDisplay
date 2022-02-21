package com.example.JavaDataDisplay.models;

public class Customer {
    private String customerId;
    private String firstName;
    private String lastName;
    private String county;
    private String postalCode;
    private String phoneNumber;
    private String email;

    public Customer(String customerId, String firstName, String lastName, String country, String postalCode, String phoneNumber, String email){
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.county = country;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    // Getters and setters ommited
}