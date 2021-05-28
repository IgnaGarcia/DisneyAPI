package com.disneyChallenge.demo.controllers;

import com.disneyChallenge.demo.models.Character;
import com.disneyChallenge.demo.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/characters")
public class CharacterController {
    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public List<Character> getCharacters(@RequestParam(required = false) String name,
                                         @RequestParam(required = false) Integer age,
                                         @RequestParam(required = false) Long movie) {
        return name != null
                ? characterService.getCharacterByName(name)
                : age != null
                ? characterService.getCharacterByAge(age)
                : movie != null
                ? characterService.getCharacterByMovie(movie)
                : characterService.getCharacters();
    }

    @GetMapping(path = "/{id}")
    public Character getCharacter(@PathVariable("id") Long id) {
        return characterService.getCharacter(id);
    }

    @PostMapping
    public Character createCharacter(@RequestBody Character character) {
        return characterService.createCharacter(character);
    }

    @PutMapping
    public Character updateCharacter(@RequestBody Character character) {
        return characterService.updateCharacter(character);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteCharacter(@PathVariable("id") Long id) {
        return characterService.deleteCharacter(id)
                ? "Character " + id + " deleted succesfully"
                : "ERROR to delete Character " + id;
    }
}
