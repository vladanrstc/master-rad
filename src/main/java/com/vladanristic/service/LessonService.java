package com.vladanristic.service;

import com.vladanristic.dtos.LessonEntity;
import com.vladanristic.entities.Lesson;

import java.util.List;

public interface LessonService {
    List<LessonEntity> getLastThreeVideos();
    boolean checkIfUserCompletedLesson(long courseId, long userId, long lessonId);
    List<Lesson> getLessonsForSection(long sectionId);
    Lesson createNewLesson(Lesson lesson);
    Lesson saveLesson(Lesson lesson);
    Lesson getLessonById(long lessonId);
    Lesson updateLesson(Lesson lesson);
    Lesson updateLessonPublishedStatus(Lesson lesson);
    boolean removeLesson(Lesson lesson);
    List<Lesson> updateLessonsOrder(List<Lesson> lessons);
}
