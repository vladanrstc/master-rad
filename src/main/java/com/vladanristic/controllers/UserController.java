package com.vladanristic.controllers;

import com.vladanristic.dtos.UserDTO;
import com.vladanristic.entities.User;
import com.vladanristic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("logged/user")
    public ResponseEntity updateLoggedUser(@RequestBody Map<String, String> userData) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = this.userService.getUser(auth.getName());

        UserDTO dtoUser = new UserDTO();
        dtoUser.setName(userData.get("name"));
        dtoUser.setLastName(userData.get("lastName"));
        dtoUser.setEmail(userData.get("email"));
        dtoUser.setCurrentPassword(userData.get("currentPassword"));
        dtoUser.setPassword(userData.get("password"));

        try {
            return new ResponseEntity<>(this.userService.updateWholeUser(currentUser, dtoUser), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/logged/user")
    public User getLoggedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return this.userService.getUser(auth.getName());
    }

}
