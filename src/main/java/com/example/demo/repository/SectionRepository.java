package com.example.demo.repository;

import com.example.demo.entities.Course;
import com.example.demo.entities.Lesson;
import com.example.demo.entities.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {

    /*@Query(value = "SELECT * FROM sections where lesson_section_id = :lessonSectionId", nativeQuery = true)
    Section findSectionByLessonSectionId(@Param("lessonSectionId") Long lessonSectionId);*/

    List<Section> findAllBySectionCourseId(Course course);

}
