package com.example.bookhavenback.entity.author;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int authorId;

    @Column(name = "author_name")
    private String authorName;
}

