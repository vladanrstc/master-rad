package com.example.demo.service;

import com.example.demo.entities.Course;
import com.example.demo.entities.Lesson;

import java.util.List;

public interface CourseService {

    List<Course> getCoursesUserEnrolledIn(Long userId);
    List<Course> getCoursesUserNotEnrolledIn(Long userId);

}
