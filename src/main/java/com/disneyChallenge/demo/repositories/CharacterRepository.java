package com.disneyChallenge.demo.repositories;

import com.disneyChallenge.demo.models.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

    List<Character> findByNameLike(String name);
    List<Character> findByAge(Integer age);
    //List<Character> findByMovies(Long movie);
}
