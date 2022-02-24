package com.example.JavaDataDisplay.models;

public class CustomerSpender {
    private int customerId;
    private double total;

    public CustomerSpender(int customerId, double total) {
        this.customerId = customerId;
        this.total = total;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
