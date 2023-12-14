package com.example.bookhavenback.entity.book;

import java.util.List;
import java.util.Optional;

public interface BookServiceInterface {
    List<Book> findAllBooks();

    Optional<Book> findBookById(int id);

    Book save(Book Book);

    void delete(Book Book);
}
