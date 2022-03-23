package com.vladanristic.repository;

import com.vladanristic.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query(value = "SELECT * FROM courses WHERE EXISTS (SELECT 1 FROM user_courses_started WHERE user_courses_started.course_id = courses.course_id AND user_courses_started.user_id = :userId)", nativeQuery = true)
    List<Course> coursesUserEnrolledIn(@Param("userId") Long userId);

    @Query(value = "SELECT * FROM courses WHERE NOT EXISTS (SELECT 1 FROM user_courses_started WHERE user_courses_started.course_id = courses.course_id AND user_courses_started.user_id = :userId)", nativeQuery = true)
    List<Course> coursesUserHasNotEnrolledIn(@Param("userId") Long userId);

    @Transactional
    Course findCourseByCourseSlug(String courseSlug);

}
