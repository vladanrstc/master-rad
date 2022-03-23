package com.vladanristic.repository;

import com.vladanristic.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

    /*@Query(value = "SELECT * FROM tests WHERE lesson_id = :lessonId", nativeQuery = true)
    Test findTestByLessonId(@Param("lessonId") int lessonId);*/

}
