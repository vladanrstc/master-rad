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
import javax.persistence.Lob;
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
@Table(name = "lessons", catalog = "vladanristic", schema = "")
@NamedQueries({
    @NamedQuery(name = "Lesson.findAll", query = "SELECT l FROM Lesson l")})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "lessonId")
public class Lesson implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lesson_id")
    private Long lessonId;

    @Basic(optional = false)
    @Column(name = "lesson_title")
    private String lessonTitle;

    @Basic(optional = false)
    @Lob
    @Column(name = "lesson_description")
    private String lessonDescription;

    @Column(name = "lesson_practice")
    private String lessonPractice;

    @Column(name = "lesson_code")
    private String lessonCode;

    @Column(name = "lesson_video_link")
    private String lessonVideoLink;

    @Column(name = "lesson_slug")
    private String lessonSlug;

    @Column(name = "lesson_order")
    private Integer lessonOrder;

    @Column(name = "lesson_published")
    private Boolean lessonPublished;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lessonId")
    private List<LessonCompleted> lessonCompletedList;

    @JoinColumn(name = "lesson_section_id", referencedColumnName = "section_id")
    @ManyToOne(optional = false)
    private Section lessonSectionId;

    @JoinColumn(name = "lesson_test_id", referencedColumnName = "test_id")
    @ManyToOne
    private Test lessonTestId;

    public Lesson() {
    }

    public Lesson(Long lessonId) {
        this.lessonId = lessonId;
    }

    public Lesson(Long lessonId, String lessonTitle, String lessonDescription) {
        this.lessonId = lessonId;
        this.lessonTitle = lessonTitle;
        this.lessonDescription = lessonDescription;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
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

    public void setLessonOrder(Integer lessonOrder) {
        this.lessonOrder = lessonOrder;
    }

    public Boolean getLessonPublished() {
        return lessonPublished;
    }

    public void setLessonPublished(Boolean lessonPublished) {
        this.lessonPublished = lessonPublished;
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

    public List<LessonCompleted> getLessonCompletedList() {
        return lessonCompletedList;
    }

    public void setLessonCompletedList(List<LessonCompleted> lessonCompletedList) {
        this.lessonCompletedList = lessonCompletedList;
    }

    public Section getLessonSectionId() {
        return lessonSectionId;
    }

    public void setLessonSectionId(Section lessonSectionId) {
        this.lessonSectionId = lessonSectionId;
    }

    public Test getLessonTestId() {
        return lessonTestId;
    }

    public void setLessonTestId(Test lessonTestId) {
        this.lessonTestId = lessonTestId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lessonId != null ? lessonId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lesson)) {
            return false;
        }
        Lesson other = (Lesson) object;
        if ((this.lessonId == null && other.lessonId != null) || (this.lessonId != null && !this.lessonId.equals(other.lessonId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "andjelina.Lesson[ lessonId=" + lessonId + " ]";
    }
    
}
