/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Vladan
 */
@Entity
@Table(name = "lessons_completed", catalog = "vladanristic", schema = "")
@NamedQueries({
    @NamedQuery(name = "LessonCompleted.findAll", query = "SELECT l FROM LessonCompleted l")})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "lessonCompletedId", scope = LessonCompleted.class)
public class LessonCompleted implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lesson_completed_id")
    private Long lessonCompletedId;

    @Column(name = "lesson_completed_flag")
    private Boolean lessonCompletedFlag;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lessonId")
    private List<TestCompleted> testCompletedList;

    @JoinColumn(name = "lesson_id", referencedColumnName = "lesson_id")
    @ManyToOne(optional = false)
    private Lesson lessonId;

    @JoinColumn(name = "course_started_id", referencedColumnName = "user_course_started_id")
    @ManyToOne(optional = false)
    private UserCourseStarted courseStartedId;

    public LessonCompleted() {
    }

    public LessonCompleted(boolean lessonCompletedFlag, Lesson lesson, UserCourseStarted courseStarted) {
        this.lessonCompletedFlag = lessonCompletedFlag;
        this.lessonId = lesson;
        this.courseStartedId = courseStarted;

    }

    public LessonCompleted(Long lessonCompletedId) {
        this.lessonCompletedId = lessonCompletedId;
    }

    public Long getLessonCompletedId() {
        return lessonCompletedId;
    }

    public void setLessonCompletedId(Long lessonCompletedId) {
        this.lessonCompletedId = lessonCompletedId;
    }

    public Boolean getLessonCompletedFlag() {
        return lessonCompletedFlag;
    }

    public void setLessonCompletedFlag(Boolean lessonCompletedFlag) {
        this.lessonCompletedFlag = lessonCompletedFlag;
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

    public List<TestCompleted> getTestCompletedList() {
        return testCompletedList;
    }

    public void setTestCompletedList(List<TestCompleted> testCompletedList) {
        this.testCompletedList = testCompletedList;
    }

    public Lesson getLessonId() {
        return lessonId;
    }

    public void setLessonId(Lesson lessonId) {
        this.lessonId = lessonId;
    }

    public UserCourseStarted getCourseStartedId() {
        return courseStartedId;
    }

    public void setCourseStartedId(UserCourseStarted courseStartedId) {
        this.courseStartedId = courseStartedId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lessonCompletedId != null ? lessonCompletedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LessonCompleted)) {
            return false;
        }
        LessonCompleted other = (LessonCompleted) object;
        if ((this.lessonCompletedId == null && other.lessonCompletedId != null) || (this.lessonCompletedId != null && !this.lessonCompletedId.equals(other.lessonCompletedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "andjelina.LessonCompleted[ lessonCompletedId=" + lessonCompletedId + " ]";
    }
    
}
