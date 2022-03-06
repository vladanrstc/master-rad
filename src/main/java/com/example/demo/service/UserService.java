package com.example.demo.service;

import com.example.demo.entities.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User createNewUser(User user);
    User getUser(String email);
    User getUser(long userId);
    List<User> getUsers();
    List<User> getAllActiveRegularUsers();
    List<User> getAllBannedUsers();
    boolean deleteUser(long userId);
    User unbanUser(long userId);
    UserDetails loadUserByUsername(String email);
    User updateWholeUser(User oldUser, User newUser) throws Exception;
    User updateUserAsAdmin(User oldUser, User newUser) throws Exception;
}
