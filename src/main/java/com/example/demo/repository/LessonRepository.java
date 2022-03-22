package com.example.demo.repository;

import com.example.demo.entities.Lesson;
import com.example.demo.entities.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson> getTop3ByLessonVideoLinkNotNull();
    List<Lesson> findAllByLessonSectionIdOrderByLessonOrderAsc(Section section);
    Lesson findFirstByLessonSectionIdOrderByLessonOrderDesc(Section section);

}
