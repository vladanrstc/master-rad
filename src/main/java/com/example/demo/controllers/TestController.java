package com.example.demo.controllers;

import com.example.demo.entities.Test;
import com.example.demo.entities.User;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test/data/{lessonId}")
    public Test getLoggedUser(@PathVariable(required = false, name = "lessonId") long lessonId) {
        return this.testService.getTestByLessonId(lessonId);
    }

    @PostMapping("test/submit/{testId}")
    public ResponseEntity<String> getTestResults(@PathVariable(required = false, name = "testId") long testId, @RequestBody Map<String, Map<String, ArrayList<Long>>> answers) {

        System.out.println(answers.get("answers"));
        System.out.println(testId);
        return ResponseEntity.ok().header("Custom-Header", "foo").body("custom header set");
    }

}
