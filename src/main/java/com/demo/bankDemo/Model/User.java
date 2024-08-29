package com.demo.bankDemo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "Bank")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name = "FIRSTNAME")
    private String firstname;

    @Column(nullable = false, name = "LASTNAME")
    private String lastname;

    @Column(unique = true, nullable = false, name = "USERNAME")
    private String username;

    @Column(nullable = false, name = "PASSWORD")
    private String password;

    @Column(unique = true, name = "AC.NAME")
    private long accountNumber;

    @Column(name = "BALANCE")
    private long balance = 5000000;

    //////////////////////////////////////////////////////////

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

    @PrePersist
    public void generateAccountNumber() {
        // Generate an 8-digit random account number
        this.accountNumber = (long) (Math.random() * 90000000L) + 10000000L;
    }

}
