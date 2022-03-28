package com.epam.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello/{userId}")
    public String sayHello(@PathVariable("userId") Integer userId, @RequestParam("username") String username, Model model){

        model.addAttribute("username", username);
        model.addAttribute("userId", userId);
        return "redirect:/bye";
    }

    @GetMapping("/bye")
    public String sayBye(){
        return "bye-page";
    }


}
