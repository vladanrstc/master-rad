package com.example.demo.service;

import com.example.demo.entities.UserCourseStarted;
import com.example.demo.repository.CourseStartedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseStartServiceImpl implements CourseStartService {

    @Autowired
    private CourseStartedRepository courseStartedRepository;

}
