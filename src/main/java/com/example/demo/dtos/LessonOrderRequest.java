package com.example.demo.dtos;

import com.example.demo.entities.Lesson;

import java.io.Serializable;
import java.util.List;

public class LessonOrderRequest implements Serializable {

    private List<Lesson> lessons;

    public LessonOrderRequest() {

    }

    public LessonOrderRequest(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
