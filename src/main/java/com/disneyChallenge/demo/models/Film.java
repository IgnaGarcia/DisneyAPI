package com.disneyChallenge.demo.models;

import com.disneyChallenge.demo.models.Character;
import java.time.LocalDate;
import java.util.List;

public class Film {
    private Integer id;
    private String image;
    private String title;
    private LocalDate date;
    private Integer rate;
    private List<Character> characterList;

    public Film() { }

    public Film(Integer id,
                String image,
                String title,
                LocalDate date,
                Integer rate,
                List<Character> characterList) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.date = date;
        this.rate = rate;
        this.characterList = characterList;
    }

    public Film(String image,
                String title,
                LocalDate date,
                Integer rate,
                List<Character> characterList) {
        this.image = image;
        this.title = title;
        this.date = date;
        this.rate = rate;
        this.characterList = characterList;
    }

    public Integer getId() { return id; }

    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) { this.date = date; }

    public Integer getRate() { return rate; }

    public void setRate(Integer rate) { this.rate = rate; }

    public List<Character> getCharacterList() { return characterList; }

    public void setCharacterList(List<Character> characterList) { this.characterList = characterList; }
}
