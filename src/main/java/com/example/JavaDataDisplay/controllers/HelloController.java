package com.example.JavaDataDisplay.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "This is the root page";
    }

    @GetMapping("/hello")
    public String greetGuest() {
        return "Hello, guest!";
    }
}