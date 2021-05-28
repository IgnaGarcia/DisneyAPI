package com.disneyChallenge.demo.services;

import com.disneyChallenge.demo.models.Character;
import com.disneyChallenge.demo.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {
    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<Character> getCharacters() {
        return characterRepository.findAll();
    }

    public Character getCharacter(Long id) {
        Optional<Character> character = characterRepository.findById(id);
        return (character != null && character.isPresent())
                ? character.get()
                : null;
    }

    public List<Character> getCharacterByName(String name) {
        return characterRepository.findByNameLike(name);
    }

    public List<Character> getCharacterByAge(Integer age) {
        return characterRepository.findByAge(age);
    }

    public List<Character> getCharacterByMovie(Long movie) {
        return null;//characterRepository.findByMovies(movie);
    }

    public Character createCharacter(Character character) {
        return (character != null && character.getId() == null)
                ? characterRepository.save(character)
                : null;
    }

    public Character updateCharacter(Character character) {
        return (character != null && getCharacter(character.getId()) != null)
                ? characterRepository.save(character)
                : null;
    }

    public Boolean deleteCharacter(Long id) {
        if (getCharacter(id) != null) characterRepository.deleteById(id);
        return getCharacter(id) == null;
    }
}
