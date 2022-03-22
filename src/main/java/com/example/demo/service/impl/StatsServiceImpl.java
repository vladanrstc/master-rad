package com.example.demo.service.impl;

import com.example.demo.repository.*;
import com.example.demo.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StatsServiceImpl implements StatsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseStartedRepository courseStartedRepository;

    @Override
    public Map<String, Long> getAppStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("users", this.userRepository.count());
        stats.put("tests", this.testRepository.count());
        stats.put("sections", this.sectionRepository.count());
        stats.put("lessons", this.lessonRepository.count());
        stats.put("courses", this.courseRepository.count());
        stats.put("courses_started", this.courseRepository.count());
        return stats;
    }

}
