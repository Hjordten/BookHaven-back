package com.example.bookhavenback.config;

import com.example.bookhavenback.entity.author.Author;
import com.example.bookhavenback.entity.author.AuthorRepository;
import com.example.bookhavenback.entity.book.Book;
import com.example.bookhavenback.entity.book.BookRepository;
import com.example.bookhavenback.entity.genre.Genre;
import com.example.bookhavenback.entity.genre.GenreRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Component
public class Startdata implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public void run(String... args) throws Exception {
            /* --------------------------------------- Create Authors ----------------------------------------------- */

            Author author1 = new Author();
            author1.setAuthorName("J.K. Rowling");

            Author author2 = new Author();
            author2.setAuthorName("George Orwell");

            Author author3 = new Author();
            author3.setAuthorName("Jane Austen");

            Author author4 = new Author();
            author4.setAuthorName("Stephen King");

            Author author5 = new Author();
            author5.setAuthorName("Agatha Christie");

            /* --------------------------------------- Save Authors to database ------------------------------------- */
            authorRepository.saveAll(Arrays.asList(author1, author2, author3, author4, author5));

             /* --------------------------------------- Create Books ------------------------------------------------ */

            Book book1 = new Book();
            book1.setBookName("Harry Potter and the Philosopher's Stone");
            book1.setAuthor(author1);

            Book book2 = new Book();
            book2.setBookName("1984");
            book2.setAuthor(author2);

            Book book3 = new Book();
            book3.setBookName("Pride and Prejudice");
            book3.setAuthor(author3);

            Book book4 = new Book();
            book4.setBookName("The Shining");
            book4.setAuthor(author4);

            Book book5 = new Book();
            book5.setBookName("Murder on the Orient Express");
            book5.setAuthor(author5);

            Book book6 = new Book();
            book6.setBookName("Sense and Sensibility");
            book6.setAuthor(author3);

            /* --------------------------------- Save Books to database --------------------------------------------- */
            bookRepository.saveAll(Arrays.asList(book1, book2, book3, book4, book5, book6));

            /* -------------------------------------- Create Genres ------------------------------------------------- */

            Genre genre1 = new Genre();
            genre1.setGenreName("Fantasy");

            Genre genre2 = new Genre();
            genre2.setGenreName("Dystopian");

            Genre genre3 = new Genre();
            genre3.setGenreName("Romance");

            Genre genre4 = new Genre();
            genre4.setGenreName("Horror");

            Genre genre5 = new Genre();
            genre5.setGenreName("Mystery");

            /* --------------------------------- Save Genres to database -------------------------------------------- */
            genreRepository.saveAll(Arrays.asList(genre1, genre2, genre3, genre4, genre5));

            /* --------------------------------- book_genre table setup --------------------------------------------- */

            /* --------------------- Step one - Retrieve the authors from database ---------------------------------- */
            Author savedAuthor1 = authorRepository.findByAuthorName("J.K. Rowling");
            Author savedAuthor2 = authorRepository.findByAuthorName("George Orwell");
            // Repeat for other authors...

            Book savedBook1 = bookRepository.findByBookName("Harry Potter and the Philosopher's Stone");
            Book savedBook2 = bookRepository.findByBookName("1984");
            // Repeat for other books...

            Genre savedGenre1 = genreRepository.findByGenreName("Fantasy");
            Genre savedGenre2 = genreRepository.findByGenreName("Dystopian");
            // Repeat for other genres...

//         Now, use the retrieved entities to create relationships
//         Example for book_genre relationship
            savedBook1.getGenreSet().add(savedGenre1);
            savedBook2.getGenreSet().add(savedGenre2);
            // Repeat for other relationships...

//
//
//        // Save the entities with relationships back to the database
            bookRepository.saveAll(Arrays.asList(savedBook1, savedBook2));
//        // Repeat for other repositories...
        }
    }



