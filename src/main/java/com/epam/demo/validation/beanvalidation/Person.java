package com.epam.demo.validation.beanvalidation;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Person {
    private int id;
    @NotBlank(message = "{name.empty}")
    private String name;
    @Min(value = 0, message = "{negative.value}")
    @Max(value= 110, message = "{too.darn.old}")
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        throw new RuntimeException("Ha ha ha");
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
