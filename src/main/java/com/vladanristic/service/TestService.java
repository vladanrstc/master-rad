package com.vladanristic.service;

import com.vladanristic.dtos.TestResultDTO;
import com.vladanristic.entities.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface TestService {

    Test getTestByLessonId(long lessonId);
    List<TestResultDTO> checkTestResults(Map<String, ArrayList<Long>> answers);

}
