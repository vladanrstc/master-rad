package com.example.demo.service;

import com.example.demo.dtos.CourseDTO;
import com.example.demo.entities.Course;
import com.example.demo.entities.Lesson;

import java.util.List;

public interface CourseService {

    List<Course> getCoursesUserEnrolledIn(Long userId);
    List<Course> getCoursesUserNotEnrolledIn(Long userId);
    CourseDTO getCourseBySlug(String courseSlug, Long userId);
    Course getCourseById(Long courseId);
    float calculateCourseAverageMark(Long courseId);
    List<CourseDTO> getAllCourses();
    boolean deleteCourse(long course);
    Course saveCourse(Course course);
}
