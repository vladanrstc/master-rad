package com.example.demo.service;

import com.example.demo.entities.UserCourseStarted;

import java.util.List;

public interface CourseStartService {

    UserCourseStarted updateUserCourseNotes(String notes, String course, long userId);
    UserCourseStarted updateUserCourseReview(int rating, String review, String course, long userId);
    List<UserCourseStarted> getCourseNotes(long courseId);
    List<UserCourseStarted> getCourseReviews(long courseId);

}
