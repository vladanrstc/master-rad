package com.example.demo.service;

import com.example.demo.entities.Section;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Section> getSectionsForCourse(long courseId) {
        List<Section> sections = this.sectionRepository.findAllBySectionCourseId(this.courseRepository.findById(courseId).get());
        sections.forEach(section -> {section.setSectionCourseId(null); section.setLessonList(null);});
        return sections;
    }

}
