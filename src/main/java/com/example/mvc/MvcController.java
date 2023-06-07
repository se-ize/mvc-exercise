package com.example.mvc;

import com.example.mvc.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MvcController {
    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Hello, Thymeleaf!");
        return "home";
    }

    @RequestMapping("/student")
    public String student(Model model) {
        model.addAttribute("object",
                new Student("SeoHyun Kim", "idshkc@gmail.com"));
        return "student";
    }

    @RequestMapping("/is-logged-in")
    public String isLoggedIn(Model model) {
        model.addAttribute("isLoggedIn", true);
        return "if-unless";
    }

    @RequestMapping("/each")
    public String items(Model model) {
        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("foo");
        listOfStrings.add("bar");
        listOfStrings.add("baz");

        model.addAttribute("listOfStrings", listOfStrings);
//        for (String item : listOfStrings);

        List<Student> studentList = Arrays.asList(
                new Student("Alex", "alex@gmail.com"),
                new Student("Brad", "brad@gmail.com"),
                new Student("Chad", "chad@gmail.com")
        );
        model.addAttribute("studentList", studentList);
        return "each";
    }
}