package com.disneyChallenge.demo.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long g_id;
    private String name;
    private String image;
    @OneToMany(mappedBy = "g_id", cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    private List<Movie> movieList;

    public Genre() {
    }

    public Genre(Long id,
                 String name,
                 String image) {
        this.g_id = id;
        this.name = name;
        this.image = image;
    }

    public Genre(String name,
                 String image) {
        this.name = name;
        this.image = image;
    }

    public Long getG_id() {
        return g_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }
}
