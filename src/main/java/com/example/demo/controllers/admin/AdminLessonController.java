package com.example.demo.controllers.admin;

import com.example.demo.dtos.UserCourseStartedDTO;
import com.example.demo.entities.Lesson;
import com.example.demo.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminLessonController {

    @Autowired
    private LessonService lessonService;

    @GetMapping(value = "lessons/section/{sectionId}")
    public List<Lesson> getLessonsForSection(@PathVariable(required = false, name = "sectionId") long sectionId) {
        return this.lessonService.getLessonsForSection(sectionId);
    }

}
