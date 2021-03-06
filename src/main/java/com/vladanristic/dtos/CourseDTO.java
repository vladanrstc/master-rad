package com.vladanristic.dtos;

import com.vladanristic.entities.Section;
import com.vladanristic.service.impl.CourseServiceImpl;
import com.vladanristic.entities.Lesson;

import java.util.List;

public class CourseDTO {

    private CourseServiceImpl courseService;

    private String courseName;
    private Long courseId;
    private String courseImage;
    private String courseSlug;
    private String courseDescription;
    private List<Section> sectionList;
    private float courseAverageMark;
    private int lessonsCount;
    private int lessonsCompletedCount;
    private List<CourseReviewDTO> reviews;
    private String userNote;

    public CourseDTO() {

    }

    public CourseDTO(String courseName, Long courseId, String courseImage, String courseSlug) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.courseImage = courseImage;
        this.courseSlug = courseSlug;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }

    public List<CourseReviewDTO> getReviews() {
        return reviews;
    }

    public void setReviews(List<CourseReviewDTO> reviews) {
        this.reviews = reviews;
    }

    public int getLessonsCompletedCount() {
        return lessonsCompletedCount;
    }

    public void setLessonsCompletedCount(int lessonsCompletedCount) {
        this.lessonsCompletedCount = lessonsCompletedCount;
    }

    public CourseServiceImpl getCourseService() {
        return courseService;
    }

    public void setCourseService(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }

    public int getLessonsCount() {
        return lessonsCount;
    }

    public void setLessonsCount(int lessonsCount) {
        this.lessonsCount = lessonsCount;
    }

    public double getCourseAverageMark() {
        return courseAverageMark;
    }

    public void setCourseAverageMark(float courseAverageMark) {
        this.courseAverageMark = courseAverageMark;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    public List<Section> getSections() {
        return sectionList;
    }

    public void setSections(List<Section> sectionList) {
        for(Section sec: sectionList) {
            sec.setSectionCourseId(null);
            for(Lesson lesson: sec.getLessonList()) {
                lesson.setLessonCompletedList(null);
            }
        }
        this.sectionList = sectionList;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }

    public String getCourseSlug() {
        return courseSlug;
    }

    public void setCourseSlug(String courseSlug) {
        this.courseSlug = courseSlug;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "courseString='" + courseName + '\'' +
                ", courseId=" + courseId +
                ", courseImage='" + courseImage + '\'' +
                '}';
    }
}
