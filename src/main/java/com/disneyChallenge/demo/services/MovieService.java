package com.disneyChallenge.demo.services;

import com.disneyChallenge.demo.models.Movie;
import com.disneyChallenge.demo.repositories.MovieRepository;
import com.disneyChallenge.demo.util.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    public List<MovieDTO> getMovies(String order) {
        return (order != null && order.equals("ASC"))
                ? MovieDTO.mapToDTO(movieRepository.findAll(Sort.by(Sort.Direction.ASC, "date")))
                : (order != null && order.equals("DESC"))
                ? MovieDTO.mapToDTO(movieRepository.findAll(Sort.by(Sort.Direction.DESC, "date")))
                : MovieDTO.mapToDTO(movieRepository.findAll());
    }

    public Movie getMovie(Long id) {
        if (id == null) throw new IllegalArgumentException();
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie != null && movie.isPresent()) return movie.get();
        else throw new NoSuchElementException();
    }

    public List<MovieDTO> getMovieByTitle(String title, String order) {
        if (title == null) throw new IllegalArgumentException();
        return (order != null && order.equals("ASC"))
                ? MovieDTO.mapToDTO(movieRepository.findByTitle(title, Sort.by(Sort.Direction.ASC, "date")))
                : (order != null && order.equals("DESC"))
                ? MovieDTO.mapToDTO(movieRepository.findByTitle(title, Sort.by(Sort.Direction.ASC, "date")))
                : MovieDTO.mapToDTO(movieRepository.findByTitle(title));
    }

    public List<MovieDTO> getMovieByGenre(Long genre, String order) {
        if (genre == null) throw new IllegalArgumentException();
        if (genreService.getGenre(genre) == null) throw new NoSuchElementException();
        return (order != null && order.equals("ASC"))
                ? MovieDTO.mapToDTO(movieRepository.findByGid(genre, Sort.by(Sort.Direction.ASC, "date")))
                : (order != null && order.equals("DESC"))
                ? MovieDTO.mapToDTO(movieRepository.findByGid(genre, Sort.by(Sort.Direction.DESC, "date")))
                : MovieDTO.mapToDTO(movieRepository.findByGid(genre));
    }

    public Movie createMovie(Movie movie) {
        if (movie == null ||
                movie.getTitle() == null ||
                movie.getM_id() != null) throw new IllegalArgumentException();
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
