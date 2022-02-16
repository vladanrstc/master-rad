/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entities;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Vladan
 */
@Entity
@Table(name = "user_courses_started", catalog = "vladanristic", schema = "")
@NamedQueries({
    @NamedQuery(name = "UserCourseStarted.findAll", query = "SELECT u FROM UserCourseStarted u")})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "userCourseStartedId", scope = UserCourseStarted.class)
public class UserCourseStarted implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_course_started_id")
    private Long userCourseStartedId;

    @Lob
    @Column(name = "user_course_started_review_text")
    private String userCourseStartedReviewText;

    @Column(name = "user_course_started_review_mark")
    private Integer userCourseStartedReviewMark;

    @Lob
    @Column(name = "user_course_started_note")
    private String userCourseStartedNote;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    @ManyToOne(optional = false)
    private Course courseId;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseStartedId")
    private List<LessonCompleted> lessonCompletedList;

    public UserCourseStarted() {
    }

    public UserCourseStarted(Long userCourseStartedId) {
        this.userCourseStartedId = userCourseStartedId;
    }

    public Long getUserCourseStartedId() {
        return userCourseStartedId;
    }

    public void setUserCourseStartedId(Long userCourseStartedId) {
        this.userCourseStartedId = userCourseStartedId;
    }

    public String getUserCourseStartedReviewText() {
        return userCourseStartedReviewText;
    }

    public void setUserCourseStartedReviewText(String userCourseStartedReviewText) {
        this.userCourseStartedReviewText = userCourseStartedReviewText;
    }

    public Integer getUserCourseStartedReviewMark() {
        return userCourseStartedReviewMark;
    }

    public void setUserCourseStartedReviewMark(Integer userCourseStartedReviewMark) {
        this.userCourseStartedReviewMark = userCourseStartedReviewMark;
    }

    public String getUserCourseStartedNote() {
        return userCourseStartedNote;
    }

    public void setUserCourseStartedNote(String userCourseStartedNote) {
        this.userCourseStartedNote = userCourseStartedNote;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public List<LessonCompleted> getLessonCompletedList() {
        return lessonCompletedList;
    }

    public void setLessonCompletedList(List<LessonCompleted> lessonCompletedList) {
        this.lessonCompletedList = lessonCompletedList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userCourseStartedId != null ? userCourseStartedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserCourseStarted)) {
            return false;
        }
        UserCourseStarted other = (UserCourseStarted) object;
        if ((this.userCourseStartedId == null && other.userCourseStartedId != null) || (this.userCourseStartedId != null && !this.userCourseStartedId.equals(other.userCourseStartedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "andjelina.UserCourseStarted[ userCourseStartedId=" + userCourseStartedId + " ]";
    }
    
}
