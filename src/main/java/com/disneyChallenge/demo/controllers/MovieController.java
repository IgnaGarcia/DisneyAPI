package com.disneyChallenge.demo.controllers;

import com.disneyChallenge.demo.models.Movie;
import com.disneyChallenge.demo.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/movies")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies(@RequestParam(required = false) String name,
                                                 @RequestParam(required = false) Long genre,
                                                 @RequestParam(required = false) String order) {
        return name != null
                ? new ResponseEntity<>(movieService.getMovieByTitle(name, order), HttpStatus.OK)
                : genre != null
                ? new ResponseEntity<>(movieService.getMovieByGenre(genre, order), HttpStatus.OK)
                : new ResponseEntity<>(movieService.getMovies(order), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable("id") Long id) {
        return new ResponseEntity<>(movieService.getMovie(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        return new ResponseEntity<>(movieService.createMovie(movie), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie) {
        return new ResponseEntity<>(movieService.updateMovie(movie), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") Long id) {
        return new ResponseEntity<>(movieService.deleteMovie(id)
                ? "Movie "+id+" deleted succesfully"
                : "ERROR to delete Movie "+id, HttpStatus.OK);
    }
}
