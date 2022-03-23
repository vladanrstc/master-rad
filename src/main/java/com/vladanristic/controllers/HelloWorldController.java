package com.vladanristic.controllers;

import com.vladanristic.entities.User;
import com.vladanristic.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloWorldController {

    private final UserServiceImpl userService;

    @Autowired
    public HelloWorldController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> helloWorld() {
        return this.userService.getUsers();
    }

    @GetMapping("/samoadmin")
    public String samoadmin() {
        return "samoadmin";
    }

    @GetMapping("/svi")
    public String svi() {
        return "svi";
    }

}
