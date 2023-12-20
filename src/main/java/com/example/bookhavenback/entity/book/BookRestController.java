package com.example.bookhavenback.entity.book;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class BookRestController {
    /*------------------------------------------INSTANCES-------------------------------------------------------------*/

    @Autowired
    private BookServiceInterface bookServiceInterface;

    /*------------------------------------------GET-------------------------------------------------------------------*/

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooksFromDatabase() {
        List<Book> bookList = bookServiceInterface.findAllBooks();
        return ResponseEntity.ok(bookList);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Optional<Book>> findBookUsingId(@PathVariable int id) {
        Optional<Book> book = bookServiceInterface.findBookById(id);
        if (book.isEmpty()) {
            throw new EntityNotFoundException("No Book with the desired id exists");
        } else {
            return ResponseEntity.ok(book);
        }
    }

    /*------------------------------------------POST-------------------------------------------------------------------*/

    @PostMapping("/book")
    public ResponseEntity<String> postBook(@RequestBody Book book) {
        Book savedBook = bookServiceInterface.save(book);
        if (savedBook == null) {
            return ResponseEntity.ok("Missing required fields");
        } else {
            return ResponseEntity.ok("New book successfully saved");
        }
    }

    /*-------------------------------------------------PUT------------------------------------------------------------*/

    @PutMapping("/book/{id}")
    public ResponseEntity<String> updateBookWithId(@PathVariable int id, @RequestBody Book book) {
        Optional<Book> foundBook = bookServiceInterface.findBookById(id);

        if (foundBook.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No book with the desired id exists");
        } else {
            foundBook.get().setBookName(book.getBookName());
            Book updatedBook = bookServiceInterface.save(foundBook.get());
            if (updatedBook != null) {
                return ResponseEntity.ok("Book was successfully updated");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update the book");
            }
        }
    }

    /*-------------------------------------------------DELETE---------------------------------------------------------*/

    @DeleteMapping("/book/{id}")
    public ResponseEntity<String> deleteBookUsingId(@PathVariable int id) {
        Optional<Book> foundBook = bookServiceInterface.findBookById(id);

        if (foundBook.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No book with the desired id exists");
        } else {
            bookServiceInterface.delete(foundBook.get());
            return ResponseEntity.ok("Book successfully deleted");
        }
    }
}