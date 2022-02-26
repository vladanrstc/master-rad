package com.example.demo.service;

import com.example.demo.entities.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

public interface TestService {

    Test getTestByLessonId(long lessonId);
    String checkTestResults(Map<String, ArrayList<Long>> answers);

}
