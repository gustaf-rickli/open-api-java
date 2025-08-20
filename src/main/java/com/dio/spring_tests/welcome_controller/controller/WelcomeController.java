package com.dio.spring_tests.welcome_controller.controller;

import com.dio.spring_tests.welcome_controller.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {


    @GetMapping
    public String welcomeWithoutPathVariable() {
        return "<h1 style=\"color: red;\">Welcome!</h1>";
    }

    @GetMapping("/{algumaCoisa}")
    public String welcomeWithPathVariable(@PathVariable String algumaCoisa) {
        return algumaCoisa;
    }



}
