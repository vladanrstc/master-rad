package com.vladanristic.repository;

import com.vladanristic.entities.Course;
import com.vladanristic.entities.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {

    /*@Query(value = "SELECT * FROM sections where lesson_section_id = :lessonSectionId", nativeQuery = true)
    Section findSectionByLessonSectionId(@Param("lessonSectionId") Long lessonSectionId);*/

    List<Section> findAllBySectionCourseIdOrderBySectionOrderAsc(Course course);
    Section findFirstBySectionCourseIdOrderBySectionOrderDesc(Course course);

}
