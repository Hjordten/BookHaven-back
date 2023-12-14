package com.example.bookhavenback.entity.book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository <Book, Integer> {

    Book findByBookName(String name);
}
