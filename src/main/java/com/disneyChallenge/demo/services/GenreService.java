package com.disneyChallenge.demo.services;

import com.disneyChallenge.demo.models.Genre;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GenreService {

    public List<Genre> getGenres() {
        return List.of(
                new Genre()
        );
    }
}
