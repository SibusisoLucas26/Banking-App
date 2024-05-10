package com.demo.bankDemo.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bank_Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name = "FIRSTNAME")
    private String firstname;

    @Column(nullable = false, name = "LASTNAME")
    private String lastname;

    @Column(unique = true, nullable = false, name = "USERNAME" )
    private String username;
    
    @Column(nullable = false, name = "PASSWORD")
    private String password;

    @Column(unique = true, name = "AC.NAME")
    private long accountNumber;

    @Column(name = "BALANCE")
    private long balance = 5000000;

    ///////////////////////////////////////////////////////////////
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public User(String firstname, String lastname, String username, String password, long accountNumber, long balance) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /////////////////////////////////////////////////

    public User(String firstname, String lastname, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        /// this.accountNumber = accountNumber;
        // this.balance = balance;
    }

    public User(long id, String username, String password, long accountNumber, long balance) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public User() {
        //TODO Auto-generated constructor stub
    }

    @PrePersist
    public void generateAccountNumber() {
        // Generate an 8-digit random account number
        this.accountNumber = (long) (Math.random() * 90000000L) + 10000000L;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
                + ", password=" + password + ", accountNumber=" + accountNumber + ", balance=" + balance + "]";
    }

    }
        
       
