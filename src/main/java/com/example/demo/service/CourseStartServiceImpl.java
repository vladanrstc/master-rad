package com.example.demo.service;

import com.example.demo.dtos.UserCourseStartedDTO;
import com.example.demo.dtos.UserDTO;
import com.example.demo.entities.UserCourseStarted;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.CourseStartedRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseStartServiceImpl implements CourseStartService {

    @Autowired
    private CourseStartedRepository courseStartedRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

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
        userCourseStarted.setUserCourseStartedReviewMark(rating);
        userCourseStarted.setUserCourseStartedReviewText(review);
        this.courseStartedRepository.save(userCourseStarted);
        return userCourseStarted;
    }

    @Override
    public List<UserCourseStartedDTO> getCourseNotes(long courseId) {
        return this.prepareUserCourseStartedData(this.courseStartedRepository.findAllByCourseIdAndUserCourseStartedNoteNotNull(this.courseRepository.findById(courseId).get()));
    }

    @Override
    public List<UserCourseStartedDTO> getCourseReviews(long courseId) {
        return this.prepareUserCourseStartedData(this.courseStartedRepository.findAllByCourseIdAndUserCourseStartedReviewMarkNotNull(this.courseRepository.findById(courseId).get()));
    }

    @Override
    public boolean deleteReview(long userCourseStartedId) {
        try {
            UserCourseStarted userCourseStarted = this.courseStartedRepository.findById(userCourseStartedId).get();
            userCourseStarted.setUserCourseStartedReviewText(null);
            userCourseStarted.setUserCourseStartedReviewMark(null);
            this.courseStartedRepository.save(userCourseStarted);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteNote(long userCourseStartedId) {
        try {
            UserCourseStarted userCourseStarted = this.courseStartedRepository.findById(userCourseStartedId).get();
            userCourseStarted.setUserCourseStartedNote(null);
            this.courseStartedRepository.save(userCourseStarted);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public UserCourseStarted enrollUserInCourse(long userId, long courseId) {
        UserCourseStarted userCourseStarted = new UserCourseStarted();
        userCourseStarted.setCourseId(this.courseRepository.getById(courseId));
        userCourseStarted.setUserId(this.userRepository.getById(userId));
        return this.courseStartedRepository.save(userCourseStarted);
    }

    private List<UserCourseStartedDTO> prepareUserCourseStartedData(List<UserCourseStarted> givenArrayOfUserCoursesStarted) {
        List<UserCourseStartedDTO> userCourseStartedDTOS = new ArrayList<>();
        for(UserCourseStarted userCourseStarted: givenArrayOfUserCoursesStarted) {
            UserCourseStartedDTO dto = new UserCourseStartedDTO();
            BeanUtils.copyProperties(userCourseStarted, dto);
            dto.setUser(new UserDTO(userCourseStarted.getUserId().getName(), userCourseStarted.getUserId().getEmail(), userCourseStarted.getUserId().getLastName()));
            userCourseStartedDTOS.add(dto);
        }
        return userCourseStartedDTOS;
    }

}
