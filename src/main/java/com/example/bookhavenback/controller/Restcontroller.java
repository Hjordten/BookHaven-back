package com.example.bookhavenback.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;

@RestController
public class Restcontroller {



    @GetMapping("/test")
    public String test (){
        return "this is a test";
    }

    @PostMapping("/api/test")
    public String testPost(@RequestBody Book book) {
        // Assuming you have a service layer to handle the book creation and persistence
        // For simplicity, we'll just print the received book details
        System.out.println("Received book: " + book.toString());
        return "Book received successfully";
    }
}
