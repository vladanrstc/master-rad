package com.example.demo.controllers;

import com.example.demo.dtos.LessonEntity;
import com.example.demo.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private LessonService lessonService;

    @GetMapping(value = "/home/videos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity homeVideos() {
        List<LessonEntity> lessons = this.lessonService.getLastThreeVideos();
        return new ResponseEntity(lessons, HttpStatus.OK);
    }

}
