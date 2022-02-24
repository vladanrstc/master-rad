package com.example.demo.repository;

import com.example.demo.entities.Lesson;
import com.example.demo.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

    /*@Query(value = "SELECT * FROM tests WHERE lesson_id = :lessonId", nativeQuery = true)
    Test findTestByLessonId(@Param("lessonId") int lessonId);*/

}
