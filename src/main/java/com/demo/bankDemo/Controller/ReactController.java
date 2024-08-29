package com.demo.bankDemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.bankDemo.Model.User;
import com.demo.bankDemo.Service.Service;

@Controller
@RequestMapping("/auth")
public class ReactController {

    @Autowired
    private Service service;

    @Autowired
    private PasswordCoder passwordCoder;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        System.out.println("Register request received: " + user);
        if (service.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username is already taken.");
        }
        User registeredUser = service.saveUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        User existingUser = service.findByUsername(user.getUsername());
        if (existingUser == null || !passwordCoder.matches(user.getPassword(), existingUser.getPassword())) {
            return ResponseEntity.badRequest().body("Invalid username or password.");
        }
        return ResponseEntity.ok("Login successful");
    }
}
