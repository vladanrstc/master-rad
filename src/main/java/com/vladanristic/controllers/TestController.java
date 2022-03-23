package com.vladanristic.controllers;

import com.vladanristic.dtos.TestResultDTO;
import com.vladanristic.entities.Test;
import com.vladanristic.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test/data/{lessonId}")
    public Test getLoggedUser(@PathVariable(required = false, name = "lessonId") long lessonId) {
        return this.testService.getTestByLessonId(lessonId);
    }

    @PostMapping("test/submit/{testId}")
    public List<TestResultDTO> getTestResults(@PathVariable(required = false, name = "testId") long testId, @RequestBody Map<String, Map<String, ArrayList<Long>>> answers) {
        return this.testService.checkTestResults(answers.get("answers"));
    }

}
