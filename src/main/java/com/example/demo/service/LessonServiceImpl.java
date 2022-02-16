package com.example.demo.service;

import com.example.demo.dtos.LessonDTO;
import com.example.demo.dtos.LessonEntity;
import com.example.demo.entities.Lesson;
import com.example.demo.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Override
    public List<LessonEntity> getLastThreeVideos() {
        List<LessonEntity> lessonsDtos = new ArrayList<>();
        lessonRepository.getTop3ByLessonVideoLinkNotNull().forEach((element) -> {
            lessonsDtos.add(new LessonDTO(element.getLessonTitle(), element.getLessonVideoLink()));
        });
        return lessonsDtos;
    }

}
