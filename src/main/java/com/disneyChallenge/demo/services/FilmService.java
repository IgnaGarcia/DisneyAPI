package com.disneyChallenge.demo.services;

import com.disneyChallenge.demo.models.Film;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FilmService {

    public List<Film> getFilms() {
        return List.of(
                new Film()
        );
    }
}
