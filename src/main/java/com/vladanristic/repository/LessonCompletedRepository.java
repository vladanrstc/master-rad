package com.vladanristic.repository;

import com.vladanristic.entities.LessonCompleted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonCompletedRepository extends JpaRepository<LessonCompleted, Long> {

    @Query(value = "SELECT * FROM lessons_completed WHERE course_started_id = :userCourseStartedId", nativeQuery = true)
    List<LessonCompleted> findAllLessonsOfStartedCourseUserHasCompleted(@Param("userCourseStartedId") Long userCourseStartedId);

    @Query(value = "SELECT * FROM lessons_completed WHERE course_started_id = :userCourseStartedId AND lesson_id = :lessonId", nativeQuery = true)
    LessonCompleted findAllLessonsOfUserStartedIdAndLessonId(@Param("userCourseStartedId") Long userCourseStartedId, @Param("lessonId") Long lessonId);


}
