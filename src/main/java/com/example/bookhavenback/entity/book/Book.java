package com.example.bookhavenback.entity.book;

import com.example.bookhavenback.entity.author.Author;
import com.example.bookhavenback.entity.genre.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@Entity
@Data
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int bookId;

    @Column(name = "book_name")
    private String bookName;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonIgnoreProperties("books")
    private Author author;

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("book")
    private Genre genre;
}

