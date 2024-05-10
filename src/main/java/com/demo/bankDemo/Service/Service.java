package com.demo.bankDemo.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.demo.bankDemo.Model.User;
import com.demo.bankDemo.Repo.UserRepository;

@org.springframework.stereotype.Service
public class Service implements ServiceInterface{

@Autowired
private UserRepository userRepository;

@Override
public  User saveUser(User user){
    return userRepository.save(user); 
}

@Override
public User editUser(User user) {
    // TODO Auto-generated method stub

    return userRepository.save(user);
   // throw new UnsupportedOperationException("Unimplemented method 'editUser'");
}

@Override
public User findByUsernameAndPassword(String username, String password) {
    // TODO Auto-generated method stub
    return userRepository.findByUsernameAndPassword(username, password);
    //throw new UnsupportedOperationException("Unimplemented method 'findByUsernameAndPassword'");
}

/* 
@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);
    if (user == null) {
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
    return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
            .password(user.getPassword())
            .build();
}*/

@Override
public User findByUsername(String username) {
    // TODO Auto-generated method stub
    return userRepository.findByUsername(username);
    //throw new UnsupportedOperationException("Unimplemented method 'findByUsername'");
}

//////////////////////////////////////////////////////////////////////////////////////////////////




}    


