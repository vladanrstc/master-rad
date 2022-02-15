package com.example.demo.service;

import com.example.demo.entities.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUser(String email);
    List<User> getUsers();
    UserDetails loadUserByUsername(String email);
}
