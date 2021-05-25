package com.disneyChallenge.demo.models;

import java.util.List;

public class Character {
    private Integer id;
    private String image;
    private String name;
    private Integer age;
    private Double weigth;
    private String history;
    private List<Film> filmList;

    public Character() { }

    public Character(Integer id,
                     String image,
                     String name,
                     Integer age,
                     Double weigth,
                     String history,
                     List<Film> filmList) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.age = age;
        this.weigth = weigth;
        this.history = history;
        this.filmList = filmList;
    }

    public Character(String image,
                     String name,
                     Integer age,
                     Double weigth,
                     String history,
                     List<Film> filmList) {
        this.image = image;
        this.name = name;
        this.age = age;
        this.weigth = weigth;
        this.history = history;
        this.filmList = filmList;
    }

    public Integer getId() { return id; }

    public String getImage() { return image;  }

    public void setImage(String image) { this.image = image; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Integer getAge() { return age; }

    public void setAge(Integer age) { this.age = age; }

    public Double getWeigth() { return weigth; }

    public void setWeigth(Double weigth) { this.weigth = weigth; }

    public String getHistory() { return history; }

    public void setHistory(String history) { this.history = history; }

    public List<Film> getFilmList() { return filmList; }

    public void setFilmList(List<Film> filmList) { this.filmList = filmList; }
}
