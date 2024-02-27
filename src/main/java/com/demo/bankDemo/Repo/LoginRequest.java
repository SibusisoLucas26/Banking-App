package com.demo.bankDemo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.bankDemo.Requests.UserLoginRequest;

public interface LoginRequest extends JpaRepository<UserLoginRequest, String> {

}
