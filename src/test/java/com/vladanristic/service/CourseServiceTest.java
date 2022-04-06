package com.vladanristic.service;

import com.vladanristic.entities.Course;
import com.vladanristic.repository.CourseRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("Test")
class CourseServiceTest {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void calculateCourseAverageMark() {
        Assertions.assertThat(courseService.calculateCourseAverageMark(
                courseRepository.findCourseByCourseSlug("90165-uvod-u-php").getCourseId())).isEqualTo(3.25f);
    }

    @Test
    void saveCourse() {
        Course course = new Course();
        course.setCourseName("Sample name1");
        course.setCourseDescription("Sample description");
        course.setCourseImage("testImage");
        Assertions.assertThat(courseService.saveCourse(course)).isNotNull();
    }

}