package com.example.demo.dtos;

import com.example.demo.entities.User;

public class CourseReviewDTO {

    private String userCourseStartedReviewText;
    private int userCourseStartedReviewMark;
    private String userCourseStartedNote;
    private User user;

    public CourseReviewDTO() {

    }

    public CourseReviewDTO(String userCourseStartedReviewText, int userCourseStartedReviewMark, String userCourseStartedNote, User user) {
        this.userCourseStartedReviewText = userCourseStartedReviewText;
        this.userCourseStartedReviewMark = userCourseStartedReviewMark;
        this.userCourseStartedNote = userCourseStartedNote;
        this.user = user;
    }

    public String getUserCourseStartedReviewText() {
        return userCourseStartedReviewText;
    }

    public void setUserCourseStartedReviewText(String userCourseStartedReviewText) {
        this.userCourseStartedReviewText = userCourseStartedReviewText;
    }

    public int getUserCourseStartedReviewMark() {
        return userCourseStartedReviewMark;
    }

    public void setUserCourseStartedReviewMark(int userCourseStartedReviewMark) {
        this.userCourseStartedReviewMark = userCourseStartedReviewMark;
    }

    public String getUserCourseStartedNote() {
        return userCourseStartedNote;
    }

    public void setUserCourseStartedNote(String userCourseStartedNote) {
        this.userCourseStartedNote = userCourseStartedNote;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "CourseReviewDTO{" +
                "userCourseStartedReviewText='" + userCourseStartedReviewText + '\'' +
                ", userCourseStartedReviewMark=" + userCourseStartedReviewMark +
                ", userCourseStartedNote='" + userCourseStartedNote + '\'' +
                ", user=" + user +
                '}';
    }
}
