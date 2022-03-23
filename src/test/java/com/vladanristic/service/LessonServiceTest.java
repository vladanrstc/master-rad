package com.vladanristic.service;

import com.vladanristic.entities.Course;
import com.vladanristic.entities.Lesson;
import com.vladanristic.entities.User;
import com.vladanristic.repository.CourseRepository;
import com.vladanristic.repository.LessonRepository;
import com.vladanristic.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
@ActiveProfiles("Test")
class LessonServiceTest {

    @Autowired
    private LessonService lessonService;

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void updateLessonPublishedStatus() {

        List<Lesson> lessonList = lessonRepository.findAll();
        Random random = new Random();

        int randomLessonIndex = random.nextInt(lessonList.size() - 1);
        Lesson randomlyPickedLesson = lessonList.get(randomLessonIndex);

        boolean currentStatus = randomlyPickedLesson.getLessonPublished();
        lessonService.updateLessonPublishedStatus(randomlyPickedLesson);

        Assertions.assertThat(randomlyPickedLesson.getLessonPublished()).isNotEqualTo(currentStatus);

    }

    @Test
    void checkIfUserCompletedLesson() {

        List<User> users = userRepository.findAll();
        List<Lesson> lessons = lessonRepository.findAll();
        List<Course> courses = courseRepository.findAll();

        Random r = new Random();

        List<Boolean> values = new ArrayList<>();
        values.add(true);
        values.add(false);

        Assertions.assertThat(lessonService.checkIfUserCompletedLesson(
                courses.get(r.nextInt(courses.size() - 1)).getCourseId(),
                lessons.get(r.nextInt(lessons.size() - 1)).getLessonId(),
                users.get(r.nextInt(users.size() - 1)).getId())).isIn(values);

    }

}