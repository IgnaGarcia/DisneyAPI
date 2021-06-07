package com.disneyChallenge.demo.services;

import com.disneyChallenge.demo.models.Character;
import com.disneyChallenge.demo.repositories.CharacterRepository;
import com.disneyChallenge.demo.util.CharacterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CharacterService {
    private final CharacterRepository characterRepository;
    private final MovieService movieService;

    @Autowired
    public CharacterService(CharacterRepository characterRepository, MovieService movieService) {
        this.characterRepository = characterRepository;
        this.movieService = movieService;
    }

    public List<CharacterDTO> getCharacters() {
        return CharacterDTO.mapToDTO(characterRepository.findAll());
    }

    public Character getCharacter(Long id) {
        if (id == null) throw new IllegalArgumentException();
        Optional<Character> character = characterRepository.findById(id);
        if (character != null && character.isPresent()) return character.get();
        else throw new NoSuchElementException();
    }

    public List<CharacterDTO> getCharacterByName(String name) {
        if (name == null || name == "") throw new IllegalArgumentException();
        return CharacterDTO.mapToDTO(characterRepository.findByNameLike(name));
    }

    public List<CharacterDTO> getCharacterByAge(Integer age) {
        if (age == null) throw new IllegalArgumentException();
        return CharacterDTO.mapToDTO(characterRepository.findByAge(age));
    }

    public List<CharacterDTO> getCharacterByMovie(Long movie) {
        if (movie == null) throw new IllegalArgumentException();
        else if (movieService.getMovie(movie) != null) return CharacterDTO.mapToDTO(characterRepository.findByMovies(movie));
        else throw new NoSuchElementException();
    }

    public Character createCharacter(Character character) {
        if (character == null ||
                character.getName() == null ||
                character.getC_id() != null) throw new IllegalArgumentException();
        else return characterRepository.save(character);
    }

    public Character updateCharacter(Character character) {
        if (character == null || character.getC_id() == null) throw new IllegalStateException();
        else if (getCharacter(character.getC_id()) == null) throw new NoSuchElementException();
        else return characterRepository.save(character);
    }

    public Boolean deleteCharacter(Long id) {
        if (id == null) throw new IllegalArgumentException();
        else if (getCharacter(id) == null) throw new NoSuchElementException();
        else {
            characterRepository.deleteById(id);
            return true;
        }
    }
}
