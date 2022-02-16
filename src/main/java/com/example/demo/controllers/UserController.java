package com.example.demo.controllers;

import com.example.demo.dtos.UserDTO;
import com.example.demo.entities.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("logged/user")
    public ResponseEntity updateLoggedUser(@RequestBody UserDTO user) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = this.userService.getUser(auth.getName());
        try {
            return new ResponseEntity<>(this.userService.updateLoggedUser(currentUser, user), HttpStatus.OK);
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
