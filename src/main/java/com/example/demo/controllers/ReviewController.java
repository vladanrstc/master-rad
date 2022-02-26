package com.example.demo.controllers;

import com.example.demo.entities.UserCourseStarted;
import com.example.demo.service.CourseStartService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
public class ReviewController {

    @Autowired
    private UserService userService;

    @Autowired
    private CourseStartService courseStartService;

    @PatchMapping("/course/started/review")
    public UserCourseStarted updateUserCourseReview(@RequestBody Map<String, String> data, Principal principal) {
        return this.courseStartService.updateUserCourseReview(Integer.parseInt(data.get("rating")), data.get("review"), data.get("course"), this.userService.getUser(principal.getName()).getId());
    }

}
