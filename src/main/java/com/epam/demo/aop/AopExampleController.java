package com.epam.demo.aop;

import com.epam.demo.validation.beanvalidation.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping(value = "/aop", headers = "Accept=*/*", produces = "application/json")
public class AopExampleController {

    private final AopService aopService;

    public AopExampleController(AopService aopService) {
        this.aopService = aopService;
    }

    // REST representational state transfer - arch. style
    @GetMapping("/persons")
    public ResponseEntity<Collection<Person>> getAllPersons() {
        return ResponseEntity.ok(aopService.getAllPersons());
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getById(@RequestParam Integer id) {
        return ResponseEntity.ok(aopService.getById(id));
    }

    @PostMapping("/persons")
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {

        Person savedPerson = aopService.save(person);
        return ResponseEntity.ok(savedPerson);
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<Person> savePerson(@RequestBody Person person, @RequestParam Integer id) {

        Person updated = aopService.update(id, person);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity<Void> deletePerson(@RequestParam Integer id) {
        aopService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
