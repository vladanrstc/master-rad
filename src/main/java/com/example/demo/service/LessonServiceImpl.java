package com.example.demo.service;

import com.example.demo.dtos.LessonDTO;
import com.example.demo.dtos.LessonEntity;
import com.example.demo.entities.Lesson;
import com.example.demo.entities.LessonCompleted;
import com.example.demo.entities.UserCourseStarted;
import com.example.demo.repository.CourseStartedRepository;
import com.example.demo.repository.LessonCompletedRepository;
import com.example.demo.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private CourseStartedRepository courseStartedRepository;

    @Autowired
    private LessonCompletedRepository lessonCompletedRepository;

    @Override
    public List<LessonEntity> getLastThreeVideos() {
        List<LessonEntity> lessonsDtos = new ArrayList<>();
        lessonRepository.getTop3ByLessonVideoLinkNotNull().forEach((element) -> {
            lessonsDtos.add(new LessonDTO(element.getLessonTitle(), element.getLessonVideoLink()));
        });
        return lessonsDtos;
    }

    @Override
    public boolean checkIfUserCompletedLesson(long courseId, long userId, long lessonId) {
        UserCourseStarted userCourseStarted = this.courseStartedRepository.getCourseStartedByCourseIdAndUserId(courseId, userId);

        if(userCourseStarted == null) {
            return false;
        }

        LessonCompleted lessonCompleted = this.lessonCompletedRepository.findAllLessonsOfUserStartedIdAndLessonId(userCourseStarted.getUserCourseStartedId(), lessonId);

        if(lessonCompleted != null) {
            return true;
        }

        return false;

    }


}
