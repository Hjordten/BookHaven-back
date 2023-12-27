package com.example.bookhavenback.entity.genre;

import com.example.bookhavenback.entity.book.Book;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int genreId;

    @Column(name = "genre_name")
    private String genreName;

    @OneToOne
    @JoinColumn(name = "book_id")
    @JsonIgnoreProperties("genre")
    private Book book;
}
