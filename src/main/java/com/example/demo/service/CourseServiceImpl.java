package com.example.demo.service;

import com.example.demo.entities.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getCoursesUserEnrolledIn(Long userId) {
        return this.courseRepository.coursesUserEnrolledIn(userId);
    }

    @Override
    public List<Course> getCoursesUserNotEnrolledIn(Long userId) {
        return this.courseRepository.coursesUserHasNotEnrolledIn(userId);
    }

}
