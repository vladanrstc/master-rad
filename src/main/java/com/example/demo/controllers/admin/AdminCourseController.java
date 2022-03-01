package com.example.demo.controllers.admin;

import com.example.demo.dtos.CourseDTO;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminCourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/courses")
    public List<CourseDTO> getAllCourses() {
        return this.courseService.getAllCourses();
    }

    @DeleteMapping(value = "/courses/{courseId}")
    public boolean deleteCourse(@PathVariable(required = false, name = "courseId") long courseId) {
        return this.courseService.deleteCourse(courseId);
    }

}
