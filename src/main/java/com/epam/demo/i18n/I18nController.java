package com.epam.demo.i18n;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class I18nController {

    @GetMapping("/i18n-example")
    public String i18nExample() {

        return "i18n";
    }
}
