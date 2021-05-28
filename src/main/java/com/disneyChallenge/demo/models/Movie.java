package com.disneyChallenge.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long m_id;
    private String image;
    private String title;
    private LocalDate date;
    private Integer rate;
    private Long g_id;
    @ManyToMany(targetEntity = Character.class, cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JsonIgnoreProperties("movieList")
    @JoinTable(
            name = "movie_characters",
            joinColumns = @JoinColumn(name = "m_id"),
            inverseJoinColumns = @JoinColumn(name = "c_id"))
    private List<Character> characterList;

    public Movie() {
    }

    public Movie(Long id,
                 String image,
                 String title,
                 LocalDate date,
                 Integer rate,
                 Long g_id) {
        this.m_id = id;
        this.image = image;
        this.title = title;
        this.date = date;
        this.rate = rate;
        this.g_id = g_id;
    }

    public Movie(String image,
                 String title,
                 LocalDate date,
                 Integer rate,
                 Long g_id) {
        this.image = image;
        this.title = title;
        this.date = date;
        this.rate = rate;
        this.g_id = g_id;
    }

    public Long getId() {
        return m_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale(Locale.US);
        this.date = LocalDate.parse(date, formatter);
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Long getG_id() {
        return g_id;
    }

    public List<Character> getCharacterList() {
        return characterList;
    }
}
