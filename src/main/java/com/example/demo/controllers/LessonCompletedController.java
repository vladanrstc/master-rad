package com.example.demo.controllers;

import com.example.demo.entities.LessonCompleted;
import com.example.demo.service.LessonCompletedService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class LessonCompletedController {

    @Autowired
    private LessonCompletedService lessonCompletedService;

    @Autowired
    private UserService userService;

    @GetMapping("/lesson/finish/{lessonId}")
    public LessonCompleted markLessonAsCompleted(@PathVariable(required = false, name = "lessonId") long lessonId, Principal principal) {
        return this.lessonCompletedService.markLessonAsCompleted(lessonId, this.userService.getUser(principal.getName()).getId());
    }

}
