package com.example.demo.service;

import com.example.demo.entities.Lesson;
import com.example.demo.repository.LessonRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("Test")
class LessonServiceTest {

    @Autowired
    private LessonService lessonService;

    @Autowired
    private LessonRepository lessonRepository;

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
}