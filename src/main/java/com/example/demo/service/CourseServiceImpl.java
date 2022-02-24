package com.example.demo.service;

import com.example.demo.dtos.CourseDTO;
import com.example.demo.dtos.CourseReviewDTO;
import com.example.demo.dtos.UserDTO;
import com.example.demo.entities.*;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.CourseStartedRepository;
import com.example.demo.repository.LessonCompletedRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseStartedRepository courseStartedRepository;

    @Autowired
    private LessonCompletedRepository lessonCompletedRepository;

    public CourseServiceImpl() {

    }

    @Override
    public float calculateCourseAverageMark(Long courseId) {
        List<UserCourseStarted> marks = this.courseStartedRepository.findUserCourseStartedByCourseIdAndUserCourseStartedReviewMarkIsNotNull(courseId);
        int sumOfMarks = 0;
        for(UserCourseStarted mark: marks) {
            sumOfMarks += mark.getUserCourseStartedReviewMark();
        }
        return (float)sumOfMarks / (float)marks.size();
    }

    @Override
    public List<Course> getCoursesUserEnrolledIn(Long userId) {
        return this.courseRepository.coursesUserEnrolledIn(userId);
    }

    @Override
    public List<Course> getCoursesUserNotEnrolledIn(Long userId) {
        return this.courseRepository.coursesUserHasNotEnrolledIn(userId);
    }

    @Override
    public CourseDTO getCourseBySlug(String slug, Long userId) {
        Course course = this.courseRepository.findCourseByCourseSlug(slug);
        CourseDTO courseDTO = new CourseDTO();
        BeanUtils.copyProperties(course, courseDTO);
        courseDTO.setSections(course.getSectionList());
        courseDTO.setCourseAverageMark(this.calculateCourseAverageMark(courseDTO.getCourseId()));

        UserCourseStarted userCourseStarted = this.courseStartedRepository.getCourseStartedByCourseIdAndUserId(course.getCourseId(), userId);
        List<LessonCompleted> lessonsCompleted = this.lessonCompletedRepository.findAllLessonsOfStartedCourseUserHasCompleted(userCourseStarted.getUserCourseStartedId());

        courseDTO.setLessonsCompletedCount(lessonsCompleted.size());
        int lessonsCount = 0;
        for(Section section: course.getSectionList()) {
            lessonsCount+=section.getLessonList().size();
        }
        courseDTO.setLessonsCount(lessonsCount);

        List<UserCourseStarted> reviews = this.courseStartedRepository.findUserCourseStartedByCourseIdAndUserCourseStartedReviewMarkIsNotNull(course.getCourseId());
        List<CourseReviewDTO> courseReviewDtos = new ArrayList<>();

        for(UserCourseStarted review: reviews) {
            CourseReviewDTO dto = new CourseReviewDTO();
            BeanUtils.copyProperties(review, dto);

            courseReviewDtos.add(dto);
            dto.setUser(new UserDTO(review.getUserId().getName(), review.getUserId().getLastName()));
        }

        courseDTO.setReviews(courseReviewDtos);
        courseDTO.setUserNote(userCourseStarted.getUserCourseStartedNote());

        return courseDTO;
    }

}