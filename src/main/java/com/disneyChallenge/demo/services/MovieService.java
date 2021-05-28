package com.disneyChallenge.demo.services;

import com.disneyChallenge.demo.models.Movie;
import com.disneyChallenge.demo.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final GenreService genreService;

    @Autowired
    public MovieService(MovieRepository movieRepository, GenreService genreService) {
        this.movieRepository = movieRepository;
        this.genreService = genreService;
    }

    public List<Movie> getMovies(String order) {
        return null;/*(order == "ASC")
                ? movieRepository.findAllOrderByDateAsc()
                : (order == "DESC")
                ? movieRepository.findAllOrderByDateDesc()
                : movieRepository.findAll();*/
    }

    public Movie getMovie(Long id) {
        if (id == null) throw new IllegalArgumentException();
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie != null && movie.isPresent()) return movie.get();
        else throw new NoSuchElementException();
    }

    public List<Movie> getMovieByTitle(String title, String order) {
        return null;/*
        if (title == null) throw new IllegalArgumentException();
        return (order == "ASC")
                ? movieRepository.findByTitleLikeOrderByDateAsc(title)
                : (order == "DESC")
                ? movieRepository.findByTitleLikeOrderByDateDesc(title)
                : movieRepository.findByTitleLike(title);*/
    }

    public List<Movie> getMovieByGenre(Long genre, String order) {
        return null;
        /*
        if (genre == null) throw new IllegalArgumentException();
        if (genreService.getGenre(genre) == null) throw new NoSuchElementException();
        return (order == "ASC")
                ? movieRepository.findByGenreOrderByDateAsc(genre)
                : (order == "DESC")
                ? movieRepository.findByGenreOrderByDateDesc(genre)
                : movieRepository.findByGenre(genre);
         */
    }

    public Movie createMovie(Movie movie) {
        if (movie == null ||
                movie.getTitle() == null ||
                getMovie(movie.getM_id()) != null) throw new IllegalArgumentException();
        else return movieRepository.save(movie);
    }

    public Movie updateMovie(Movie movie) {
        if (movie == null || movie.getM_id() == null) throw new IllegalStateException();
        else if (getMovie(movie.getM_id()) == null) throw new NoSuchElementException();
        else return movieRepository.save(movie);
    }

    public Boolean deleteMovie(Long id) {
        if (id == null) throw new IllegalArgumentException();
        else if (getMovie(id) == null) throw new NoSuchElementException();
        else {
            movieRepository.deleteById(id);
            return true;
        }
    }
}
