package com.example.bookhavenback.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Restcontroller {


    @GetMapping("/test")
    public String test (){
        return "this is a test";
    }
}
