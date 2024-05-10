package com.demo.bankDemo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.bankDemo.Model.User;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
   // User findPassword(String password);
   // User save();
    
    

}
