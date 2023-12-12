package com.example.bookhavenback.entity.book;

import com.example.bookhavenback.entity.author.Author;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    private String bookName;

    @ManyToOne
    @JoinColumn(name = "authorId", nullable = false)
    private Author author;
}

