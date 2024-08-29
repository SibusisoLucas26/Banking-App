package com.demo.bankDemo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.demo.bankDemo.Controller.PasswordCoder;
import com.demo.bankDemo.Model.User;
import com.demo.bankDemo.Repo.UserRepository;

@org.springframework.stereotype.Service
public class Service implements ServiceInterface, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordCoder passwordCoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordCoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User editUser(User user) {
        // TODO Auto-generated method stub

        return userRepository.save(user);
        // throw new UnsupportedOperationException("Unimplemented method 'editUser'");
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    // from spring security library

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                // .roles("USER") // Add roles as needed
                .build();
    }

}
