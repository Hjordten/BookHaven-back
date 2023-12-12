package com.example.bookhavenback.entity.author;

import java.util.List;

public interface AuthorServiceInterface {
    List<Author> findAllAuthors();

    Author findAuthorById(int id);

    Author save(Author author);

    void delete(Author author);

}
