package com.example.demo.repository;

import com.example.demo.entities.LessonCompleted;
import com.example.demo.entities.UserCourseStarted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonCompletedRepository extends JpaRepository<LessonCompleted, Long> {

    @Query(value = "SELECT * FROM lessons_completed WHERE course_started_id = :userCourseStartedId", nativeQuery = true)
    List<LessonCompleted> findAllLessonsOfStartedCourseUserHasCompleted(@Param("userCourseStartedId") Long userCourseStartedId);

}
