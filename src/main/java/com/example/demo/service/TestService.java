package com.example.demo.service;

import com.example.demo.entities.Test;

import java.util.Optional;

public interface TestService {

    Test getTestByLessonId(long lessonId);

}
