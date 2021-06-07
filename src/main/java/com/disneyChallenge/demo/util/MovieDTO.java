package com.disneyChallenge.demo.util;

import com.disneyChallenge.demo.models.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovieDTO {
    public Long m_id;
    public String image;
    public String title;
    public LocalDate date;

    public MovieDTO(Movie movie){
        this.m_id = movie.getM_id();
        this.image = movie.getImage();
        this.title = movie.getTitle();
        this.date = movie.getDate();
    }

    public static List<MovieDTO> mapToDTO(List<Movie> movieList){
        List<MovieDTO> list = new ArrayList<>();
        for(Movie m : movieList){
            list.add(new MovieDTO(m));
        }
        return list;
    }
}
