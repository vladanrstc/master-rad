package com.vladanristic.controllers.admin;

import com.vladanristic.dtos.UserCourseStartedDTO;
import com.vladanristic.service.CourseStartService;
import org.springframework.beans.factory.annotation.Autowired;
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
