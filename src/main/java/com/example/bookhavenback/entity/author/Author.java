package com.example.bookhavenback.entity.author;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;

    private String authorName;
}

