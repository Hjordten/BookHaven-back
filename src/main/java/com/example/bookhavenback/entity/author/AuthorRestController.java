package com.example.bookhavenback.entity.author;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class AuthorRestController {


    /*------------------------------------------INSTANCES-------------------------------------------------------------*/

    @Autowired
    private AuthorServiceInterface authorServiceInterface;

    /*------------------------------------------GET-------------------------------------------------------------------*/

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAuthorsFromDatabase() {
        List<Author> authorList = authorServiceInterface.findAllAuthors();
        return ResponseEntity.ok(authorList);
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<Optional<Author>> findAuthorUsingId(@PathVariable int id) {
        Optional<Author> author = authorServiceInterface.findAuthorById(id);
        if (author.isEmpty()) {
            throw new EntityNotFoundException("No Author with the desired id exists");
        } else {
            return ResponseEntity.ok(author);
        }
    }

    /*------------------------------------------POST-------------------------------------------------------------------*/

    @PostMapping("/author")
    public ResponseEntity<String> postAuthor(@RequestBody Author author) {
        Author savedAuthor = authorServiceInterface.save(author);
        if (savedAuthor == null) {
            return ResponseEntity.ok("Missing required fields");
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body("New author successfully saved");
        }
    }

    /*-------------------------------------------------PUT------------------------------------------------------------*/

    @PutMapping("/author/{id}")
    public ResponseEntity<String> updateAuthorWithId(@PathVariable int id, @RequestBody Author author) {
        Optional<Author> foundAuthor = authorServiceInterface.findAuthorById(id);

        if (foundAuthor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No author with the desired id exists");
        } else {
            author.setAuthorName(author.getAuthorName());
            Author updatedAuthor = authorServiceInterface.save(author);
            if (updatedAuthor != null) {
                return ResponseEntity.ok("Author was successfully updated");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update the author");
            }
        }
    }

    /*-------------------------------------------------DELETE---------------------------------------------------------*/

    @DeleteMapping("/author/{id}")
    public ResponseEntity<String> deleteAuthorUsingId(@PathVariable int id) {
        Optional<Author> foundAuthor = authorServiceInterface.findAuthorById(id);

        if (foundAuthor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No author with the desired id exists");
        } else {
            authorServiceInterface.delete(foundAuthor.get());
            return ResponseEntity.ok("Author successfully deleted");
        }
    }
}