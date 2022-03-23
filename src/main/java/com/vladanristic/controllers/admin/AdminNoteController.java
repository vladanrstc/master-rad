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
public class AdminNoteController {

    @Autowired
    private CourseStartService courseStartService;

    @GetMapping(value = "/notes/course/{courseId}")
    public List<UserCourseStartedDTO> getAllCourseNotes(@PathVariable(required = false, name = "courseId") long courseId) {
        return this.courseStartService.getCourseNotes(courseId);
    }

    @DeleteMapping(value = "/notes/{userCourseStartedId}")
    public boolean deleteUserNote(@PathVariable(required = false, name = "userCourseStartedId") long userCourseStartedId) {
        return this.courseStartService.deleteNote(userCourseStartedId);
    }

}
