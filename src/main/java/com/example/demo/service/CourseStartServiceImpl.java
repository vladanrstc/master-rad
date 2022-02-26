package com.example.demo.service;

import com.example.demo.entities.UserCourseStarted;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.CourseStartedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseStartServiceImpl implements CourseStartService {

    @Autowired
    private CourseStartedRepository courseStartedRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public UserCourseStarted updateUserCourseNotes(String notes, String courseSlug, long userId) {
        UserCourseStarted userCourseStarted = this.courseStartedRepository.getCourseStartedByCourseIdAndUserId(this.courseRepository.findCourseByCourseSlug(courseSlug).getCourseId(), userId);
        userCourseStarted.setUserCourseStartedNote(notes);
        this.courseStartedRepository.save(userCourseStarted);
        return userCourseStarted;
    }

    @Override
    public UserCourseStarted updateUserCourseReview(int rating, String review, String courseSlug, long userId) {
        UserCourseStarted userCourseStarted = this.courseStartedRepository.getCourseStartedByCourseIdAndUserId(this.courseRepository.findCourseByCourseSlug(courseSlug).getCourseId(), userId);
        System.out.println(rating);
        System.out.println(review);
        userCourseStarted.setUserCourseStartedReviewMark(rating);
        userCourseStarted.setUserCourseStartedReviewText(review);
        this.courseStartedRepository.save(userCourseStarted);
        return userCourseStarted;
    }
}
