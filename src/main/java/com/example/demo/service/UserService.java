package com.example.demo.service;

import com.example.demo.entities.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUser(String email);
    User getUser(long userId);
    List<User> getUsers();
    List<User> getAllActiveRegularUsers();
    List<User> getAllBannedUsers();
    UserDetails loadUserByUsername(String email);
    User updateLoggedUser(User oldUser, User newUser) throws Exception;
}
