package com.example.bookhavenback.entity.author;

import java.util.List;
import java.util.Optional;

public interface AuthorServiceInterface {
    List<Author> findAllAuthors();

    Optional<Author> findAuthorById(int id);

    Author save(Author author);

    void delete(Author author);

}
