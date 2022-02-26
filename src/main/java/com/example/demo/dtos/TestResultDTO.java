package com.example.demo.dtos;

import com.example.demo.entities.Answer;
import com.example.demo.entities.Question;

import java.io.Serializable;

public class TestResultDTO implements Serializable {

    private boolean correct;
    private Question question;

    public TestResultDTO() {
    }

    public TestResultDTO(boolean correct, Question question) {
        this.correct = correct;
        this.question = question;

        this.question.setTestResultList(null);
        this.question.setTestId(null);

        for(Answer answer: question.getAnswerList()) {
            answer.setTestResultList(null);
            answer.setQuestionId(null);
        }
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
