package com.epam.demo.aop;

import com.epam.demo.validation.beanvalidation.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AopExampleService implements AopService{
    private Logger logger = LoggerFactory.getLogger(AopExampleService.class);

    private final Map<Integer, Person> persons = new HashMap<>();
    private int id = 0;

//    @PostConstruct
    public void init(){
        save(new Person("Poghos", 18));
        save(new Person("Petros", 20));
    }

    @Override
    public Collection<Person> getAllPersons() {
        logger.info("Entering getAllPersons method...");
        return persons.values();
    }

    @Override
    public Person save(Person person) {
        logger.info("Entering save method...");
        person.setId(id++);
        persons.put(person.getId(), person);
        return person;
    }

    @Override
    public Person getById(Integer id) {
        logger.info("Entering getById method...");
        return persons.get(id);
    }

    @Override
    public Person update(Integer id, Person person) {
        logger.info("Entering update method...");
        person.setId(id);
        persons.put(id, person);
        return person;
    }

    @Override
    public void delete(Integer id) {
        logger.info("Entering delete method...");
        persons.remove(id);
    }
}
