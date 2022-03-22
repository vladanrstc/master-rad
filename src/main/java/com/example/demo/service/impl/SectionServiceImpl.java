package com.example.demo.service.impl;

import com.example.demo.entities.Course;
import com.example.demo.entities.Section;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.SectionRepository;
import com.example.demo.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Section> getSectionsForCourse(long courseId) {
        List<Section> sections = this.sectionRepository.findAllBySectionCourseIdOrderBySectionOrderAsc(this.courseRepository.findById(courseId).get());
        sections.forEach(section -> {section.setSectionCourseId(null); section.setLessonList(null);});
        return sections;
    }

    @Override
    public List<Section> updateSectionsOrder(List<Section> sections) {
        int counter = 1;
        for(Section section: sections) {
            Section currentSection = this.sectionRepository.getById(section.getSectionId());
            currentSection.setSectionOrder(counter);
            this.sectionRepository.save(currentSection);
            counter++;
        }
        return sections;
    }

    @Override
    public Section addNewSection(Map<String, String> section) {
        Section section1 = new Section();
        section1.setSectionName(section.get("sectionName"));
        Course course = this.courseRepository.getById(Long.parseLong(section.get("sectionCourseId")));
        section1.setSectionCourseId(course);
        section1.setSectionOrder(this.sectionRepository.findFirstBySectionCourseIdOrderBySectionOrderDesc(course).getSectionOrder() + 1);
        return this.sectionRepository.save(section1);
    }

    @Override
    public boolean removeSection(long sectionId) {
        try {
            this.sectionRepository.delete(this.sectionRepository.getById(sectionId));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Section updateSection(Map<String, String> section, long sectionId) {
        Section currentSection = this.sectionRepository.findById(sectionId).get();
        currentSection.setSectionName(section.get("sectionName"));
        this.sectionRepository.save(currentSection);
        return currentSection;
    }

    @Override
    public Section getSectionById(long sectionId) {
        return this.sectionRepository.getById(sectionId);
    }

}
