package com.epam.demo.validation.beanvalidation;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Person {
    private int id;
    @SpecialNameConstraint
    private String name;
    @Min(value = 0, message = "{negativevalue}")
    @Max(value= 110, message = "{to.darn.old}")
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
