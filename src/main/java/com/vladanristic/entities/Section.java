/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vladanristic.entities;

import com.fasterxml.jackson.annotation.*;

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
@Table(name = "sections")
@NamedQueries({
    @NamedQuery(name = "Section.findAll", query = "SELECT s FROM Section s")})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "sectionId", scope = Section.class)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Section implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "section_id")
    private Long sectionId;

    @Basic(optional = false)
    @Column(name = "section_name")
    private String sectionName;

    @Column(name = "section_order")
    private Integer sectionOrder;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @JoinColumn(name = "section_course_id", referencedColumnName = "course_id")
    @ManyToOne(optional = false)
    private Course sectionCourseId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lessonSectionId")
    private List<Lesson> lessonList;

    public Section() {
    }

    public Section(Long sectionId) {
        this.sectionId = sectionId;
    }

    public Section(Long sectionId, String sectionName) {
        this.sectionId = sectionId;
        this.sectionName = sectionName;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Integer getSectionOrder() {
        return sectionOrder;
    }

    public void setSectionOrder(Integer sectionOrder) {
        this.sectionOrder = sectionOrder;
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

    public Course getSectionCourseId() {
        return sectionCourseId;
    }

    public void setSectionCourseId(Course sectionCourseId) {
        this.sectionCourseId = sectionCourseId;
    }

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sectionId != null ? sectionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Section)) {
            return false;
        }
        Section other = (Section) object;
        if ((this.sectionId == null && other.sectionId != null) || (this.sectionId != null && !this.sectionId.equals(other.sectionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "andjelina.Section[ sectionId=" + sectionId + " ]";
    }
    
}
