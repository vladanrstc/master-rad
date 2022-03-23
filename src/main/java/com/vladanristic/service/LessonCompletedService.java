package com.vladanristic.service;

import com.vladanristic.entities.LessonCompleted;

public interface LessonCompletedService {

    LessonCompleted markLessonAsCompleted(long lessonId, long userId);

}
