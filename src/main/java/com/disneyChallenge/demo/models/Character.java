package com.disneyChallenge.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "characters")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String name;
    private Integer age;
    private Double weigth;
    private String history;
    @ManyToMany(targetEntity = Movie.class,
            mappedBy = "characterList",
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JsonIgnoreProperties("characterList")
    private List<Movie> movieList;

    public Character() {
    }

    public Character(Long id) {
        this.id = id;
    }

    public Character(Long id,
                     String image,
                     String name,
                     Integer age,
                     Double weigth,
                     String history) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.age = age;
        this.weigth = weigth;
        this.history = history;
    }

    public Character(String image,
                     String name,
                     Integer age,
                     Double weigth,
                     String history) {
        this.image = image;
        this.name = name;
        this.age = age;
        this.weigth = weigth;
        this.history = history;
    }

    public Long getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getWeigth() {
        return weigth;
    }

    public void setWeigth(Double weigth) {
        this.weigth = weigth;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

}
