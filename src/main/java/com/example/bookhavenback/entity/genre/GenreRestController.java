package com.example.bookhavenback.entity.genre;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class GenreRestController  {

    /*------------------------------------------INSTANCES-------------------------------------------------------------*/

    @Autowired
    private GenreServiceInterface genreServiceInterface;

    /*------------------------------------------GET-------------------------------------------------------------------*/

    @GetMapping("/genres")
    public ResponseEntity<List<Genre>> getGenresFromDatabase() {
        List<Genre> GenreList = genreServiceInterface.findAllGenres();
        return ResponseEntity.ok(GenreList);
    }

    @GetMapping("/genre/{id}")
    public ResponseEntity<Optional<Genre>> findGenreUsingId(@PathVariable int id) {
        Optional<Genre> genre = genreServiceInterface.findGenreById(id);
        if (genre.isEmpty()) {
            throw new EntityNotFoundException("No Genre with the desired id exists");
        } else {
            return ResponseEntity.ok(genre);
        }
    }

    /*------------------------------------------POST-------------------------------------------------------------------*/

    @PostMapping("/genre")
    public ResponseEntity<String> postGenre(@RequestBody Genre Genre) {
        Genre savedGenre = genreServiceInterface.save(Genre);
        if (savedGenre == null) {
            return ResponseEntity.ok("Missing required fields");
        } else {
            return ResponseEntity.ok("New Genre successfully saved");
        }
    }

    /*-------------------------------------------------PUT------------------------------------------------------------*/

    @PutMapping("/genre/{id}")
    public ResponseEntity<String> updateGenreWithId(@PathVariable int id, @RequestBody Genre genre) {
        Optional<Genre> foundGenre = genreServiceInterface.findGenreById(id);

        if (foundGenre.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Genre with the desired id exists");
        } else {
            foundGenre.get().setGenreName(genre.getGenreName());
            Genre updatedGenre = genreServiceInterface.save(foundGenre.get());
            if (updatedGenre != null) {
                return ResponseEntity.ok("Genre was successfully updated");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update the Genre");
            }
        }
    }

    /*-------------------------------------------------DELETE---------------------------------------------------------*/

    @DeleteMapping("/genre/{id}")
    public ResponseEntity<String> deleteGenreUsingId(@PathVariable int id) {
        Optional<Genre> foundGenre = genreServiceInterface.findGenreById(id);

        if (foundGenre.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Genre with the desired id exists");
        } else {
            genreServiceInterface.delete(foundGenre.get());
            return ResponseEntity.ok("Genre successfully deleted");
        }
    }

}
