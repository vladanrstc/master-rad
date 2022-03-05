package com.example.demo.controllers;

import com.example.demo.dtos.CourseDTO;
import com.example.demo.dtos.LessonEntity;
import com.example.demo.dtos.SectionDTO;
import com.example.demo.entities.Course;
import com.example.demo.entities.User;
import com.example.demo.entities.UserCourseStarted;
import com.example.demo.service.CourseService;
import com.example.demo.service.CourseStartService;
import com.example.demo.service.FileStorageService;
import com.example.demo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @Autowired
    private FileStorageService fileStorageService;

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

    @GetMapping(value = "/courses/started", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CourseDTO> userCoursesStarted(Principal principal) {
        return this.formListOfCourses(courseService.getCoursesUserEnrolledIn(this.userService.getUser(principal.getName()).getId()));
    }

    @GetMapping(value = "/courses/not-started", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CourseDTO> userCoursesNotStarted(Principal principal) {
        return this.formListOfCourses(courseService.getCoursesUserNotEnrolledIn(this.userService.getUser(principal.getName()).getId()));
    }

    @GetMapping(value = "/course/details/{courseSlug}")
    public CourseDTO getCourseDetails(@PathVariable(required = false, name = "courseSlug") String courseSlug, Principal principal) {
        return this.courseService.getCourseBySlug(courseSlug, this.userService.getUser(principal.getName()).getId());
    }

    private List<CourseDTO> formListOfCourses(List<Course> courses) {
        List<CourseDTO> listOfCourses = new ArrayList<>();
        for (Course course: courses) {
            listOfCourses.add(new CourseDTO(course.getCourseName(), course.getCourseId(), course.getCourseImage(), course.getCourseSlug()));
        }
        return listOfCourses;
    }

}
