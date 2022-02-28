package com.example.demo.service;

import com.example.demo.entities.Section;

import java.util.List;

public interface SectionService {

    List<Section> getSectionsForCourse(long courseId);

}
