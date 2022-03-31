package com.epam.demo.prg;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/prg")
public class PrgFormController {

    private Map<Integer, User> users = new HashMap<>();


    @GetMapping("/simple-form")
    public String showSimpleForm(Model model) {
        model.addAttribute("users", users);
        model.addAttribute("user", new User());

        return "prg-simple-form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user, Model model) {
        user.setId(users.size() + 1);
        users.put(user.getId(), user);
        model.addAttribute("users", users);
        model.addAttribute("user", new User());
        return "redirect: /prg/simple-form";
    }
}
