package com.disneyChallenge.demo.controllers;

import com.disneyChallenge.demo.models.Movie;
import com.disneyChallenge.demo.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Movie> getMovies(@RequestParam(required = false) String name,
                                 @RequestParam(required = false) Long genre,
                                 @RequestParam(required = false) String order) {
        return name != null
                ? movieService.getMovieByTitle(name, order)
                : genre != null
                ? movieService.getMovieByGenre(genre, order)
                : movieService.getMovies(order);
    }

    @GetMapping(path = "/{id}")
    public Movie getMovie(@PathVariable("id") Long id) {
        return movieService.getMovie(id);
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    @PutMapping
    public Movie updateMovie(@RequestBody Movie movie) {
        return movieService.updateMovie(movie);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteMovie(@PathVariable("id") Long id) {
        return movieService.deleteMovie(id)
                ? "Movie "+id+" deleted succesfully"
                : "ERROR to delete Movie "+id;
    }
}
