package com.example.demo.controllers.admin;

import com.example.demo.dtos.UserCourseStartedDTO;
import com.example.demo.entities.Section;
import com.example.demo.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminSectionsController {

    @Autowired
    private SectionService sectionService;

    @GetMapping(value = "/sections/course/{courseId}")
    public List<Section> getSectionsForCourse(@PathVariable(required = false, name = "courseId") long courseId) {
        return this.sectionService.getSectionsForCourse(courseId);
    }

}
