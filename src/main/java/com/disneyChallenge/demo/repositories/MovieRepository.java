package com.disneyChallenge.demo.repositories;

import com.disneyChallenge.demo.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {


    List<Movie> findAllOrderByDateDesc();
    List<Movie> findAllOrderByDateAsc();

    List<Movie> findByTitleLike(String title);
    List<Movie> findByTitleLikeOrderByDateDesc(String title);
    List<Movie> findByTitleLikeOrderByDateAsc(String title);
    /*
    List<Movie> findByGenre(Long genre);
    List<Movie> findByGenreOrderByDateDesc(Long genre);
    List<Movie> findByGenreOrderByDateAsc(Long genre);
     */
}
