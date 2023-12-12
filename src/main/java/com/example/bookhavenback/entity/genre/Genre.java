package com.example.bookhavenback.entity.genre;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genreId;

    private String genreName;
}
