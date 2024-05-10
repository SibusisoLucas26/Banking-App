package com.demo.bankDemo.Service;

import com.demo.bankDemo.Model.User;

public interface ServiceInterface {

    User saveUser(User user);
    User editUser(User user);
    User findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
   // UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    
}
