package com.example.demo.service;

import com.example.demo.dtos.QuestionDTO;
import com.example.demo.entities.Question;
import com.example.demo.entities.Test;
import com.example.demo.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;

    @Override
    public Test getTestByLessonId(long lessonId) {
        Optional<Test> test = this.testRepository.findById(lessonId);
        Test foundTest = null;
        if(test.isPresent()) {
            foundTest = test.get();

            List<Question> listOfQuestionDTOs = new ArrayList<>();
            for(Question question: foundTest.getQuestionList()) {
                question.calculateQuestionType();
            }

        }

        return foundTest;

    }

}
