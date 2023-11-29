package com.example.bookhavenback.azuretest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/students")
    public List<Student> listStudents() {
        return studentRepository.findAll();
    }


}
