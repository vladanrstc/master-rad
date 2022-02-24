package com.example.demo.controllers;

import com.example.demo.entities.Test;
import com.example.demo.entities.User;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test/data/{lessonId}")
    public Test getLoggedUser(@PathVariable(required = false, name = "lessonId") long lessonId) {
        return this.testService.getTestByLessonId(lessonId);
    }

}
