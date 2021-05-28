package com.disneyChallenge.demo.services;

import com.disneyChallenge.demo.models.Movie;
import com.disneyChallenge.demo.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies(String order) {
        return null;/*(order == "ASC")
                ? movieRepository.findAllOrderByDateAsc()
                : (order == "DESC")
                ? movieRepository.findAllOrderByDateDesc()
                : movieRepository.findAll();*/
    }

    public Movie getMovie(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        return (movie != null && movie.isPresent())
                ? movie.get()
                : null;
    }

    public List<Movie> getMovieByTitle(String title, String order) {
        return null;/*(order == "ASC")
                ? movieRepository.findByTitleLikeOrderByDateAsc(title)
                : (order == "DESC")
                ? movieRepository.findByTitleLikeOrderByDateDesc(title)
                : movieRepository.findByTitleLike(title);*/
    }

    public List<Movie> getMovieByGenre(Long genre, String order) {
        return null;
        /*
        return (order == "ASC")
                ? movieRepository.findByGenreOrderByDateAsc(genre)
                : (order == "DESC")
                ? movieRepository.findByGenreOrderByDateDesc(genre)
                : movieRepository.findByGenre(genre);
         */
    }

    public Movie createMovie(Movie movie) {
        return (movie != null && movie.getId() == null)
                ? movieRepository.save(movie)
                : null;
    }

    public Movie updateMovie(Movie movie) {
        return (movie != null && getMovie(movie.getId()) != null)
                ? movieRepository.save(movie)
                : null;
    }

    public Boolean deleteMovie(Long id) {
        if (getMovie(id) != null) movieRepository.deleteById(id);
        return getMovie(id) == null;
    }
}
