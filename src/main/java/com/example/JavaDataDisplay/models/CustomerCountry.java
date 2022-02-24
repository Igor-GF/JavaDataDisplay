package com.example.JavaDataDisplay.models;

public class CustomerCountry {
    private String country;
    private int customers;

    public CustomerCountry(String country, int customers) {
        this.customers = customers;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCustomers() {
        return customers;
    }

    public void setCustomers(int customers) {
        this.customers = customers;
    }
}
