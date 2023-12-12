package com.example.bookhavenback.entity.composite;

import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Table(name = "book_genre_id")
public class BookGenreId implements Serializable {
    private int bookId;
    private int genreId;
}
