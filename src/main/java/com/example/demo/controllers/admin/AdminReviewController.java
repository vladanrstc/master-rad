package com.example.demo.controllers.admin;

import com.example.demo.dtos.CourseDTO;
import com.example.demo.dtos.UserCourseStartedDTO;
import com.example.demo.entities.UserCourseStarted;
import com.example.demo.service.CourseStartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminReviewController {

    @Autowired
    private CourseStartService courseStartService;

    @GetMapping(value = "/reviews/course/{courseId}")
    public List<UserCourseStartedDTO> getAllCourseReviews(@PathVariable(required = false, name = "courseId") long courseId) {
        return this.courseStartService.getCourseReviews(courseId);
    }

    @DeleteMapping(value = "/reviews/{userCourseStartedId}")
    public boolean removeReview(@PathVariable(required = false, name = "userCourseStartedId") long userCourseStartedId) {
        return this.courseStartService.deleteReview(userCourseStartedId);
    }

}
