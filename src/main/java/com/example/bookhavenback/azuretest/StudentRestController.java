package com.example.bookhavenback.azuretest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentRestController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/")
    public String detteErRoden() {
        return "Du er i roden af JPAStudent22";
    }

    @GetMapping("/student")
    public String test() { return "du er ikke i roden";}




}
