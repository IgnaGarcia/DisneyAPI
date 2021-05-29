package com.disneyChallenge.demo.services;

import com.disneyChallenge.demo.models.Genre;
import com.disneyChallenge.demo.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }

    public Genre getGenre(Long id) {
        if (id == null) throw new IllegalArgumentException();
        Optional<Genre> genre = genreRepository.findById(id);
        if (genre != null && genre.isPresent()) return genre.get();
        else throw new NoSuchElementException();
    }
}
