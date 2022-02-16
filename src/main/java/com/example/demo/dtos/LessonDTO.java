package com.example.demo.dtos;

import com.example.demo.entities.Lesson;

public class LessonDTO extends Lesson implements LessonEntity{

    private String lessonTitle;
    private String lessonDescription;
    private String lessonPractice;
    private String lessonCode;
    private String lessonVideoLink;
    private String lessonSlug;
    private int lessonOrder;
    private boolean lessonPublished;

    public LessonDTO() {

    }

    public LessonDTO(String lessonTitle, String lessonVideoLink) {
        this.lessonTitle = lessonTitle;
        this.lessonVideoLink = lessonVideoLink;
    }

    public LessonDTO(String lessonTitle, String lessonDescription, String lessonPractice, String lessonCode, String lessonVideoLink, String lessonSlug, int lessonOrder, boolean lessonPublished) {
        this.lessonTitle = lessonTitle;
        this.lessonDescription = lessonDescription;
        this.lessonPractice = lessonPractice;
        this.lessonCode = lessonCode;
        this.lessonVideoLink = lessonVideoLink;
        this.lessonSlug = lessonSlug;
        this.lessonOrder = lessonOrder;
        this.lessonPublished = lessonPublished;
    }

    public String getLessonTitle() {
        return lessonTitle;
    }

    public void setLessonTitle(String lessonTitle) {
        this.lessonTitle = lessonTitle;
    }

    public String getLessonDescription() {
        return lessonDescription;
    }

    public void setLessonDescription(String lessonDescription) {
        this.lessonDescription = lessonDescription;
    }

    public String getLessonPractice() {
        return lessonPractice;
    }

    public void setLessonPractice(String lessonPractice) {
        this.lessonPractice = lessonPractice;
    }

    public String getLessonCode() {
        return lessonCode;
    }

    public void setLessonCode(String lessonCode) {
        this.lessonCode = lessonCode;
    }

    public String getLessonVideoLink() {
        return lessonVideoLink;
    }

    public void setLessonVideoLink(String lessonVideoLink) {
        this.lessonVideoLink = lessonVideoLink;
    }

    public String getLessonSlug() {
        return lessonSlug;
    }

    public void setLessonSlug(String lessonSlug) {
        this.lessonSlug = lessonSlug;
    }

    public Integer getLessonOrder() {
        return lessonOrder;
    }

    public void setLessonOrder(int lessonOrder) {
        this.lessonOrder = lessonOrder;
    }

    public boolean isLessonPublished() {
        return lessonPublished;
    }

    public void setLessonPublished(boolean lessonPublished) {
        this.lessonPublished = lessonPublished;
    }
}
