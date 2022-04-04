package com.epam.demo.validation.beanvalidation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/bean-validation")
public class BeanValidationController {

    private Map<Integer, Person> persons = new HashMap<>();


    @GetMapping("/simple-form")
    public String showSimpleForm(Model model) {
        model.addAttribute("persons", persons);
        model.addAttribute("person", new Person());

        return "spring-validation";
    }

    @PostMapping("/save")
    public String saveUser(@Valid Person person, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "spring-validation";
        }
        person.setId(persons.size()+1);
        persons.put(persons.size()+1, person);
        return "redirect: /bean-validation/simple-form";
    }
}
