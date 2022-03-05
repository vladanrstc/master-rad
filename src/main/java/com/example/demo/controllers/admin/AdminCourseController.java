package com.example.demo.controllers.admin;

import com.example.demo.dtos.CourseDTO;
import com.example.demo.entities.Course;
import com.example.demo.service.CourseService;
import com.example.demo.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class AdminCourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping(value = "/courses")
    public List<CourseDTO> getAllCourses() {
        return this.courseService.getAllCourses();
    }

    @DeleteMapping(value = "/courses/{courseId}")
    public boolean deleteCourse(@PathVariable(required = false, name = "courseId") long courseId) {
        return this.courseService.deleteCourse(courseId);
    }

    @PostMapping(path = "/courses", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public Course createNewCourse(
            @RequestParam String courseName,
            @RequestParam String courseDescription,
            @RequestPart("courseImage") MultipartFile courseImage) {

        try {
            String fileName = fileStorageService.storeFile(courseImage);

            Course newCourse = new Course();
            newCourse.setCourseName(courseName);
            newCourse.setCourseDescription(courseDescription);
            newCourse.setCourseImage("http://localhost/vladanristicjava/uploads/" + fileName);
            return this.courseService.saveCourse(newCourse);

        } catch (Exception e) {
            return null;
        }

    }

    @PostMapping(path = "/courses/update/{courseId}", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public Course updateCourse(
            @PathVariable(required = false, name = "courseId") Long courseId,
            @RequestParam String courseName,
            @RequestParam String courseDescription,
            @RequestPart(required = false, name = "courseImage") MultipartFile courseImage) {

        try {
            Course existingCourse = this.courseService.getCourseById(courseId);

            if(courseImage != null) {
                String fileName = fileStorageService.storeFile(courseImage);
                existingCourse.setCourseImage("http://localhost/vladanristicjava/uploads/" + fileName);
            }

            existingCourse.setCourseName(courseName);
            existingCourse.setCourseDescription(courseDescription);
            return this.courseService.saveCourse(existingCourse);
        } catch (Exception e) {
            return null;
        }

    }

}
