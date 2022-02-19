package com.example.demo.dtos;

public class CourseDTO {

    private String courseName;
    private Long courseId;
    private String courseImage;
    private String courseSlug;

    public CourseDTO(String courseName, Long courseId, String courseImage, String courseSlug) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.courseImage = courseImage;
        this.courseSlug = courseSlug;
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
