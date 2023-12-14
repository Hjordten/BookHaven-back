package com.example.bookhavenback.entity.genre;

import java.util.List;
import java.util.Optional;

public interface GenreServiceInterface {
    List<Genre> findAllGenres();

    Optional<Genre> findGenreById(int id);

    Genre save(Genre genre);

    void delete(Genre genre);
}
