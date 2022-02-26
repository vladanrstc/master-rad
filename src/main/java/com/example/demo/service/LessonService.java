package com.example.demo.service;

import com.example.demo.dtos.LessonEntity;
import com.example.demo.entities.Lesson;

import java.util.List;

public interface LessonService {
    List<LessonEntity> getLastThreeVideos();
    boolean checkIfUserCompletedLesson(long courseId, long userId, long lessonId);
}
