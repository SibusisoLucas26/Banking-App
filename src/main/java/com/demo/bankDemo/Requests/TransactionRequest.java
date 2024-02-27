package com.demo.bankDemo.Requests;

public class TransactionRequest {
    private String username;
    private double amount;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TransactionRequest(String username, double amount) {
        this.username = username;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransactionRequest [username=" + username + ", amount=" + amount + "]";
    }

}
