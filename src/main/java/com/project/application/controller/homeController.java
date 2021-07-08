package com.project.application.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("home")
@CrossOrigin(origins ="*")
public class homeController {

    @GetMapping("/")
    String HomePage() {
        return "home";
    }


}
