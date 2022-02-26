package com.example.demo.service;

import com.example.demo.dtos.QuestionDTO;
import com.example.demo.entities.Answer;
import com.example.demo.entities.Question;
import com.example.demo.entities.Test;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

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

    @Override
    public String checkTestResults(Map<String, ArrayList<Long>> answers) {

        for (Map.Entry<String, ArrayList<Long>> entry : answers.entrySet()) {
            String questionId = entry.getKey();
            ArrayList<Long> answerIds = entry.getValue();
            boolean areAnswersCorrect = this.checkQuestionAnswers(questionId, answerIds);
            System.out.println(areAnswersCorrect);
        }

        return "aaa";

    }

    private boolean checkQuestionAnswers(String questionId, ArrayList<Long> answerIds) {
        List<Answer> allQuestionsCorrectAnswers = this.questionRepository.findById(Long.parseLong(questionId)).get().getAnswerList().stream().filter(answer -> answer.getAnswerTrue()).collect(Collectors.toList());
        List<Answer> givenAnswers = this.answerRepository.findAllById(answerIds);
        return allQuestionsCorrectAnswers.equals(givenAnswers);
    }

}
