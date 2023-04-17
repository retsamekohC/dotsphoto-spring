package ru.vafonov.dotsphotospring.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class IndexController {

    @GetMapping
    public String hello() {
        return "Hello world";
    }
}
