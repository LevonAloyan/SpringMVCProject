package com.epam.demo.thymeleaf;

import java.util.List;

public class Question {

    private int id;
    private String question;
    private List<Answer> answers;



    public int getId() {
        return id;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public String getQuestion() {
        return question;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
