package com.example.daillyplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoteController {
    @GetMapping("/home")
    public String home(){
        return "home";
    }


}
