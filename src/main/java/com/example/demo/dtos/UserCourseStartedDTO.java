package com.example.demo.dtos;

import com.example.demo.entities.User;

public class UserCourseStartedDTO {

    private long userCourseStartedId;
    private String userCourseStartedReviewText;
    private int userCourseStartedReviewMark;
    private String userCourseStartedNote;
    private UserDTO user;

    public UserCourseStartedDTO() {

    }

    public UserCourseStartedDTO(long userCourseStartedId, String userCourseStartedReviewText, int userCourseStartedReviewMark, String userCourseStartedNote, UserDTO user) {
        this.userCourseStartedId = userCourseStartedId;
        this.userCourseStartedReviewText = userCourseStartedReviewText;
        this.userCourseStartedReviewMark = userCourseStartedReviewMark;
        this.userCourseStartedNote = userCourseStartedNote;
        this.user = user;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public long getUserCourseStartedId() {
        return userCourseStartedId;
    }

    public void setUserCourseStartedId(long userCourseStartedId) {
        this.userCourseStartedId = userCourseStartedId;
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

}
