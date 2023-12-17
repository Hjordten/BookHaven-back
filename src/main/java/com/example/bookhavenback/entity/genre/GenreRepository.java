package com.example.bookhavenback.entity.genre;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

    Genre findByGenreName(String name);

}
