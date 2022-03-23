package com.vladanristic.controllers;

import com.vladanristic.entities.UserCourseStarted;
import com.vladanristic.service.CourseStartService;
import com.vladanristic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
public class NotesController {

    @Autowired
    private CourseStartService courseStartService;

    @Autowired
    private UserService userService;

    @PatchMapping("/course/started/notes")
    public UserCourseStarted updateUserCourseNotes(@RequestBody Map<String, String> data, Principal principal) {
        return this.courseStartService.updateUserCourseNotes(data.get("notes"), data.get("course"), this.userService.getUser(principal.getName()).getId());
    }

}
