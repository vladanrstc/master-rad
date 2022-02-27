package com.example.demo.controllers.admin;

import com.example.demo.entities.UserCourseStarted;
import com.example.demo.service.CourseStartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminNoteController {

    @Autowired
    private CourseStartService courseStartService;

    @GetMapping(value = "/notes/course/{courseId}")
    public List<UserCourseStarted> getAllCourseNotes(@PathVariable(required = false, name = "courseId") long courseId) {
        return this.courseStartService.getCourseNotes(courseId);
    }

}
