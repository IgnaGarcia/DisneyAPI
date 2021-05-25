package com.disneyChallenge.demo.models;

import com.disneyChallenge.demo.models.Film;
import java.util.List;

public class Genre {
    private Integer id;
    private String name;
    private String image;
    private List<Film> filmList;

    public Genre() { }

    public Genre(Integer id,
                 String name,
                 String image,
                 List<Film> filmList) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.filmList = filmList;
    }

    public Genre(String name,
                 String image,
                 List<Film> filmList) {
        this.name = name;
        this.image = image;
        this.filmList = filmList;
    }

    public Integer getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }

    public List<Film> getFilmList() { return filmList; }

    public void setFilmList(List<Film> filmList) { this.filmList = filmList; }
}
