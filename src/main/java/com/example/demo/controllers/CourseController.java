package com.example.demo.controllers;

import com.example.demo.dtos.CourseDTO;
import com.example.demo.entities.Course;
import com.example.demo.entities.UserCourseStarted;
import com.example.demo.service.CourseService;
import com.example.demo.service.CourseStartService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseStartService courseStartService;

    @PostMapping(value = "/user_courses_started")
    public UserCourseStarted enrollInCourse(@RequestBody Course course, Principal principal) {
        return this.courseStartService.enrollUserInCourse(this.userService.getUser(principal.getName()).getId(), course.getCourseId());
    }

    @GetMapping(value = "/courses/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping(value = "/courses/started", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CourseDTO> userCoursesStarted(Principal principal) {
        return this.formListOfCourses(courseService.getCoursesUserEnrolledIn(this.userService.getUser(principal.getName()).getId()));
    }

    @GetMapping(value = "/courses/not-started", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CourseDTO> userCoursesNotStarted(Principal principal) {
        return this.formListOfCourses(courseService.getCoursesUserNotEnrolledIn(this.userService.getUser(principal.getName()).getId()));
    }

    @GetMapping(value = "/course/details/{courseSlug}")
    public CourseDTO getCourseDetails(@PathVariable(required = false, name = "courseSlug") String courseSlug, Principal principal) {
        return this.courseService.getCourseBySlug(courseSlug, this.userService.getUser(principal.getName()).getId());
    }

    private List<CourseDTO> formListOfCourses(List<Course> courses) {
        List<CourseDTO> listOfCourses = new ArrayList<>();
        for (Course course: courses) {
            listOfCourses.add(new CourseDTO(course.getCourseName(), course.getCourseId(), course.getCourseImage(), course.getCourseSlug()));
        }
        return listOfCourses;
    }

}
