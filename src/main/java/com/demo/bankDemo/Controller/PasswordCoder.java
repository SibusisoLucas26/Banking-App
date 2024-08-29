package com.demo.bankDemo.Controller;
/* */

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordCoder implements PasswordEncoder {

    
private final int strength;

    public PasswordCoder() {
        this(10); // Default strength of 10
    }

    public PasswordCoder(int strength) {
        this.strength = strength;
        //TODO Auto-generated constructor stub
    }

    

    @Override
    public String encode(CharSequence rawPassword) {
        if (rawPassword == null) {
            throw new IllegalArgumentException("Raw password cannot be null");
        }
        return new BCryptPasswordEncoder(strength).encode(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (rawPassword == null || encodedPassword == null) {
            throw new IllegalArgumentException("Raw password or encoded password cannot be null");
        }
        return new BCryptPasswordEncoder(strength).matches(rawPassword.toString(), encodedPassword);
    }
    

}
