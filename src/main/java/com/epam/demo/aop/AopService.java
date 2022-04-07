package com.epam.demo.aop;

import com.epam.demo.validation.beanvalidation.Person;

import java.util.Collection;

public interface AopService {

    Collection<Person> getAllPersons();

    Person save(Person person);

    Person getById(Integer id);

    Person update(Integer id, Person person);

    void delete(Integer id);
}
