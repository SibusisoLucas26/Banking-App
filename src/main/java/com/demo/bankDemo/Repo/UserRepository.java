package com.demo.bankDemo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.bankDemo.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
      User findByUsername(String username);
     

}
