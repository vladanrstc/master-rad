package com.example.demo.service;

import com.example.demo.dtos.LessonEntity;
import com.example.demo.entities.Lesson;
import com.example.demo.entities.Section;

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
