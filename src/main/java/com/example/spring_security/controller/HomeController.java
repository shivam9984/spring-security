package com.example.spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/home")
public class HomeController {

    @GetMapping("/welcome")
    public String home(){
        // In a real application, you might redirect to a home page or return a view name
        return "Welcome to the home page";
    }
}
