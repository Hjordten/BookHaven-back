package com.example.bookhavenback.entity.composite;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookGenreId implements Serializable {
    private int bookId;
    private int genreId;
}
