package com.vladanristic.dtos;

import com.vladanristic.entities.Question;
import com.vladanristic.enums.QuestionTypes;

public class QuestionDTO extends Question {

    private Enum<QuestionTypes> questionType;

    public QuestionDTO() {
        this.calculateQuestionType();
    }

    public Enum<QuestionTypes> getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Enum<QuestionTypes> questionType) {
        this.questionType = questionType;
    }

    public void calculateQuestionType() {
        if(this.getAnswerList().size() > 0) {
            this.questionType = QuestionTypes.MULTIPLE;
        } else {
            this.questionType = QuestionTypes.SINGLE;
        }
    }

}
