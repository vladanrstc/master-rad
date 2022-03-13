package com.example.demo.service;

import com.example.demo.repository.CourseRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("Test")
class CourseServiceTest {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void calculateCourseAverageMark() {
        Assertions.assertThat(courseService.calculateCourseAverageMark(courseRepository.findCourseByCourseSlug("90165-uvod-u-php").getCourseId())).isEqualTo(3.25f);
    }
}