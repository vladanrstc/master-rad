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
@Table(name = "tests_completed")
@NamedQueries({
    @NamedQuery(name = "TestCompleted.findAll", query = "SELECT t FROM TestCompleted t")})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "testCompletedId", scope = TestCompleted.class)
public class TestCompleted implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "test_completed_id")
    private Long testCompletedId;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @JoinColumn(name = "lesson_id", referencedColumnName = "lesson_completed_id")
    @ManyToOne(optional = false)
    private LessonCompleted lessonId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "testCompletedId")
    private List<TestResult> testResultList;

    public TestCompleted() {
    }

    public TestCompleted(Long testCompletedId) {
        this.testCompletedId = testCompletedId;
    }

    public Long getTestCompletedId() {
        return testCompletedId;
    }

    public void setTestCompletedId(Long testCompletedId) {
        this.testCompletedId = testCompletedId;
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

    public LessonCompleted getLessonId() {
        return lessonId;
    }

    public void setLessonId(LessonCompleted lessonId) {
        this.lessonId = lessonId;
    }

    public List<TestResult> getTestResultList() {
        return testResultList;
    }

    public void setTestResultList(List<TestResult> testResultList) {
        this.testResultList = testResultList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (testCompletedId != null ? testCompletedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestCompleted)) {
            return false;
        }
        TestCompleted other = (TestCompleted) object;
        if ((this.testCompletedId == null && other.testCompletedId != null) || (this.testCompletedId != null && !this.testCompletedId.equals(other.testCompletedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "andjelina.TestCompleted[ testCompletedId=" + testCompletedId + " ]";
    }
    
}
