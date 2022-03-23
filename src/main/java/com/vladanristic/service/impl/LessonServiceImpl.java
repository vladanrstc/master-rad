package com.vladanristic.service.impl;

import com.vladanristic.dtos.LessonDTO;
import com.vladanristic.dtos.LessonEntity;
import com.vladanristic.entities.Lesson;
import com.vladanristic.entities.LessonCompleted;
import com.vladanristic.entities.UserCourseStarted;
import com.vladanristic.repository.CourseStartedRepository;
import com.vladanristic.repository.LessonCompletedRepository;
import com.vladanristic.repository.LessonRepository;
import com.vladanristic.repository.SectionRepository;
import com.vladanristic.service.LessonService;
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

    @Autowired
    private SectionRepository sectionRepository;

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

    @Override
    public List<Lesson> getLessonsForSection(long sectionId) {
        List<Lesson> lessons = this.lessonRepository.findAllByLessonSectionIdOrderByLessonOrderAsc(this.sectionRepository.findById(sectionId).get());
        lessons.forEach(lesson -> {
            lesson.setLessonCompletedList(null);
            lesson.setLessonTestId(null);
            lesson.setLessonSectionId(null);
        });
        return lessons;
    }

    @Override
    public Lesson createNewLesson(Lesson lesson) {
        lesson.setLessonOrder(this.lessonRepository.findFirstByLessonSectionIdOrderByLessonOrderDesc(lesson.getLessonSectionId()).getLessonOrder() + 1);
        return this.lessonRepository.save(lesson);
    }

    @Override
    public Lesson saveLesson(Lesson lesson) {
        return this.lessonRepository.save(lesson);
    }

    @Override
    public Lesson getLessonById(long lessonId) {
        return this.lessonRepository.getById(lessonId);
    }

    @Override
    public Lesson updateLesson(Lesson lesson) {
        return this.lessonRepository.save(lesson);
    }

    @Override
    public Lesson updateLessonPublishedStatus(Lesson lesson) {
        lesson.setLessonPublished(!lesson.getLessonPublished());
        return this.lessonRepository.save(lesson);
    }

    @Override
    public boolean removeLesson(Lesson lesson) {
        try {
            this.lessonRepository.delete(lesson);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public List<Lesson> updateLessonsOrder(List<Lesson> lessons) {
        int counter = 1;
        for(Lesson lesson: lessons) {
            Lesson currentLesson = this.lessonRepository.getById(lesson.getLessonId());
            currentLesson.setLessonOrder(counter);
            this.lessonRepository.save(currentLesson);
            counter++;
        }
        return lessons;
    }

}
