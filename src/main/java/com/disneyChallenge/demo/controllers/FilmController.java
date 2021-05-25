package com.disneyChallenge.demo.controllers;

import com.disneyChallenge.demo.models.Film;
import com.disneyChallenge.demo.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/film")
public class FilmController {
    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) { this.filmService = filmService; }

    @GetMapping
    public List<Film> getFilms() { return filmService.getFilms(); }
}
