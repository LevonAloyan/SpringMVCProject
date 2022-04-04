package com.epam.demo.validation.springvalidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/spring-validation")
public class SpringValidationController {

    private Map<Integer, Person> persons = new HashMap<>();

    @Autowired
    private Validator personValidator;


    @GetMapping("/simple-form")
    public String showSimpleForm(Model model) {
        model.addAttribute("persons", persons);
        model.addAttribute("person", new Person());

        return "spring-validation";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute Person person, BindingResult bindingResult) {

        personValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors()) {
            return "spring-validation";
        }
        person.setId(persons.size()+1);
        persons.put(persons.size()+1, person);
        return "redirect: /spring-validation/simple-form";
    }
}
