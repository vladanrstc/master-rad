package com.example.demo.service;

import com.example.demo.dtos.TestResultDTO;
import com.example.demo.entities.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface TestService {

    Test getTestByLessonId(long lessonId);
    List<TestResultDTO> checkTestResults(Map<String, ArrayList<Long>> answers);

}
