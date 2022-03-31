package com.epam.demo.thymeleaf;

public class Answer {

    private int id;
    private int weight;
    private String answer;

    public Answer(int id, int weight, String answer) {
        this.id = id;
        this.weight = weight;
        this.answer = answer;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
