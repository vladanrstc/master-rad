package com.example.demo.service;

import com.example.demo.dtos.UserCourseStartedDTO;
import com.example.demo.entities.UserCourseStarted;

import java.util.List;

public interface CourseStartService {

    UserCourseStarted updateUserCourseNotes(String notes, String course, long userId);
    UserCourseStarted updateUserCourseReview(int rating, String review, String course, long userId);
    List<UserCourseStartedDTO> getCourseNotes(long courseId);
    List<UserCourseStartedDTO> getCourseReviews(long courseId);
    boolean deleteReview(long userCourseStartedId);
    boolean deleteNote(long userCourseStartedId);
    UserCourseStarted enrollUserInCourse(long userId, long courseId);

}
