package com.example.bookhavenback.entity.book;

import com.example.bookhavenback.entity.author.Author;
import com.example.bookhavenback.entity.genre.Genre;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
    @JoinColumn(name = "author_id")  // Column name in the Book table that references Author
    private Author author;

    @Getter
    @Setter
    @ManyToMany
    @JoinTable(
            name = "book_genre",  // Name of the join table
            joinColumns = @JoinColumn(name = "book_id"),  // Column name in the join table that references Book
            inverseJoinColumns = @JoinColumn(name = "genre_id")  // Column name in the join table that references Genre
    )
    private Set<Genre> genreSet;


}

