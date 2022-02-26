package com.example.demo.service;

import com.example.demo.entities.LessonCompleted;

public interface LessonCompletedService {

    LessonCompleted markLessonAsCompleted(long lessonId, long userId);

}
