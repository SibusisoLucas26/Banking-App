package com.demo.bankDemo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String password;
    
    @Column(unique = true)
    private long accountNumber;
    private long balance;
///////////////////////////////////////////////////////////////
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public long getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }
    public long getBalance() {
        return balance;
    }
    public void setBalance(long balance) {
        this.balance = balance;
    }
    //////////////////////////////////////////////////////////

    
    public User(String username, String password, long accountNumber, long balance) {
        this.username = username;
        this.password = password;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public User(long id, String username, String password, long accountNumber, long balance) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public User() {
    }

    @PrePersist
    public void generateAccountNumber() {
        // Generate an 8-digit random account number
        this.accountNumber = (long) (Math.random() * 90000000L) + 10000000L;
    }
    
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", accountNumber="
                + accountNumber + ", balance=" + balance + "]";
    }
    
    //////////////////////////////////////////////////////////
    
    
    
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'setUsername'");
    }
        
       
