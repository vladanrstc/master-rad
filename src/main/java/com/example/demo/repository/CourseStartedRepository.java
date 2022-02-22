package com.example.demo.repository;

import com.example.demo.entities.Course;
import com.example.demo.entities.UserCourseStarted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CourseStartedRepository extends JpaRepository<UserCourseStarted, Long> {

    @Query(value = "SELECT * FROM user_courses_started WHERE course_id = :courseId AND user_course_started_review_mark IS NOT NULL", nativeQuery = true)
    List<UserCourseStarted> findUserCourseStartedByCourseIdAndUserCourseStartedReviewMarkIsNotNull(@Param("courseId") Long courseId);

    @Query(value = "SELECT * FROM user_courses_started WHERE course_id = :courseId AND user_id = :userId", nativeQuery = true)
    UserCourseStarted getCourseStartedByCourseIdAndUserId(@Param("courseId") Long courseId, @Param("userId") Long userId);

}
