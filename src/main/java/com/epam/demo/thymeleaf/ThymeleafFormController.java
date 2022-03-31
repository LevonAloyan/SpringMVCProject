package com.epam.demo.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class ThymeleafFormController {

    private List<Question> questions;

    public ThymeleafFormController() {
        this.questions = createDummyQuestions();
    }

    @GetMapping("/main-page")
    public String mainPage(Model model) {
        model.addAttribute("questions", questions);
        model.addAttribute("results", new Results());
        return "questions";
    }

    @PostMapping("/submitResults")
    public String submitResult(@ModelAttribute Results results){

        System.out.println(results);

        return "questions";
    }


    public List<Question> createDummyQuestions() {
        return IntStream.range(0, 5).mapToObj(i -> {
            Question question = new Question();
            question.setId(i);
            question.setQuestion("The capital of Armenia");
            question.setAnswers(List.of(new Answer(1, 5, "Yerevan"),
                    new Answer(2, 8, "Gyumri"),
                    new Answer(3, 10, "Goris"),
                    new Answer(4, 100, "Antananarivu")));
            return question;
        }).collect(Collectors.toList());


    }
}
