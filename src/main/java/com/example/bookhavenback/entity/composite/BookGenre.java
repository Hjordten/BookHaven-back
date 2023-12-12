package com.example.bookhavenback.entity.composite;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;

@Entity
@Data
@IdClass(BookGenreId.class) // This annotation is for the composite primary key
public class BookGenre {
    @Id
    private int bookId;
    @Id
    private int genreId;
}