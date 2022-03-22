package com.example.demo.service.impl;

import com.example.demo.dtos.LessonEntity;
import com.example.demo.entities.*;
import com.example.demo.repository.*;
import com.example.demo.service.LessonCompletedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonCompletedServiceImpl implements LessonCompletedService {

    @Autowired
    private LessonCompletedRepository lessonCompletedRepository;

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseStartedRepository courseStartedRepository;

    @Override
    public LessonCompleted markLessonAsCompleted(long lessonId, long userId) {
        Lesson lesson = this.lessonRepository.getById(lessonId);
        Section section = this.sectionRepository.findById(lesson.getLessonSectionId().getSectionId()).get();
        Course course = this.courseRepository.findById(section.getSectionCourseId().getCourseId()).get();
        UserCourseStarted userCourseStarted = this.courseStartedRepository.getCourseStartedByCourseIdAndUserId(course.getCourseId(), userId);
        LessonCompleted lessonCompleted = this.lessonCompletedRepository.save(new LessonCompleted(true, lesson, userCourseStarted));
        lessonCompleted.setTestCompletedList(null);
        lessonCompleted.setCourseStartedId(null);
        lessonCompleted.setTestCompletedList(null);
        lessonCompleted.setLessonId(null);
        return lessonCompleted;
    }

}
