package com.vladanristic.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("Test")
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void ShouldFindCourseByCourseSlug() {
        Assertions.assertThat(courseRepository.findCourseByCourseSlug("90165-uvod-u-php")).isNotNull();
    }
}