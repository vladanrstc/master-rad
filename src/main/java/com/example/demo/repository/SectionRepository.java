package com.example.demo.repository;

import com.example.demo.entities.Lesson;
import com.example.demo.entities.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SectionRepository extends JpaRepository<Section, Long> {

    /*@Query(value = "SELECT * FROM sections where lesson_section_id = :lessonSectionId", nativeQuery = true)
    Section findSectionByLessonSectionId(@Param("lessonSectionId") Long lessonSectionId);*/

}
