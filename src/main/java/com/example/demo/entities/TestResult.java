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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Vladan
 */
@Entity
@Table(name = "test_results", catalog = "vladanristic", schema = "")
@NamedQueries({
    @NamedQuery(name = "TestResult.findAll", query = "SELECT t FROM TestResult t")})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "testResultId", scope = TestResult.class)
public class TestResult implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "test_result_id")
    private Long testResultId;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @JoinColumn(name = "answer_id", referencedColumnName = "answer_id")
    @ManyToOne(optional = false)
    private Answer answerId;

    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    @ManyToOne(optional = false)
    private Question questionId;

    @JoinColumn(name = "test_completed_id", referencedColumnName = "test_completed_id")
    @ManyToOne(optional = false)
    private TestCompleted testCompletedId;

    public TestResult() {
    }

    public TestResult(Long testResultId) {
        this.testResultId = testResultId;
    }

    public Long getTestResultId() {
        return testResultId;
    }

    public void setTestResultId(Long testResultId) {
        this.testResultId = testResultId;
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

    public Answer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Answer answerId) {
        this.answerId = answerId;
    }

    public Question getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Question questionId) {
        this.questionId = questionId;
    }

    public TestCompleted getTestCompletedId() {
        return testCompletedId;
    }

    public void setTestCompletedId(TestCompleted testCompletedId) {
        this.testCompletedId = testCompletedId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (testResultId != null ? testResultId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestResult)) {
            return false;
        }
        TestResult other = (TestResult) object;
        if ((this.testResultId == null && other.testResultId != null) || (this.testResultId != null && !this.testResultId.equals(other.testResultId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "andjelina.TestResult[ testResultId=" + testResultId + " ]";
    }
    
}
