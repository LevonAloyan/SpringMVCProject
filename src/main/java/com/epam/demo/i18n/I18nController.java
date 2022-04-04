package com.epam.demo.i18n;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@Controller
public class I18nController {

    @Autowired
    private MessageSource messageSource;

    @Value("${lang.change}")
    private String value;

    @GetMapping("/i18n-example")
    public String i18nExample() {
        messageSource.getMessage("lang.change", null, Locale.ENGLISH);
        messageSource.getMessage("lang.change", null, Locale.FRANCE);
        return "i18n";
    }
}
