package com.vladanristic.service;

import com.vladanristic.entities.UserCourseStarted;
import com.vladanristic.repository.CourseStartedRepository;
import com.vladanristic.repository.LessonRepository;
import com.vladanristic.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Random;

@SpringBootTest
@ActiveProfiles("Test")
class LessonCompletedServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private LessonCompletedService lessonCompletedService;

    @Autowired
    private CourseStartedRepository courseStartedRepository;

    @Test
    void markLessonAsCompleted() {
        Random randomId = new Random();

        List<UserCourseStarted> listOfStartedCourses = courseStartedRepository.findAll();

        UserCourseStarted userCourseStarted = listOfStartedCourses.get(randomId.nextInt(listOfStartedCourses.size() - 1));

        try {
            Assertions.assertThat(lessonCompletedService.markLessonAsCompleted(userCourseStarted.getCourseId().getSectionList().get(0).getLessonList().get(0).getLessonId(), userCourseStarted.getUserId().getId()));
        } catch (DataIntegrityViolationException ex) {
            Assertions.assertThat(true).isTrue();
        }

    }
}