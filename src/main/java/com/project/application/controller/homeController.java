package com.project.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homeController {
    @GetMapping("/")
    String HomePage() {
        return "<h1>Welcome to homepage! </h1>";
    }
}
