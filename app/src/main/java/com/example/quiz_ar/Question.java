package com.example.quiz_ar;

public class Question {
    private int questionId;
    private boolean answer;

    public Question(int questionId, boolean answer){
        this.questionId = questionId;
        this.answer = answer;
    }

    public boolean isTrueAnswer(){
        return this.answer;
    }

    public int getQuestionId() {
        return this.questionId;
    }
}
