package com.vladanristic.service;

import com.vladanristic.dtos.CourseDTO;
import com.vladanristic.entities.Course;

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
