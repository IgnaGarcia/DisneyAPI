package com.disneyChallenge.demo.controllers;

import com.disneyChallenge.demo.models.Character;
import com.disneyChallenge.demo.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Character>> getCharacters(@RequestParam(required = false) String name,
                                                         @RequestParam(required = false) Integer age,
                                                         @RequestParam(required = false) Long movies) {
        return name != null
                ? new ResponseEntity<>(characterService.getCharacterByName(name), HttpStatus.OK)
                : age != null
                ? new ResponseEntity<>(characterService.getCharacterByAge(age), HttpStatus.OK)
                : movies != null
                ? new ResponseEntity<>(characterService.getCharacterByMovie(movies), HttpStatus.OK)
                : new ResponseEntity<>(characterService.getCharacters(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Character> getCharacter(@PathVariable("id") Long id) {
        return new ResponseEntity<>(characterService.getCharacter(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Character> createCharacter(@RequestBody Character character) {
        return new ResponseEntity<>(characterService.createCharacter(character), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Character> updateCharacter(@RequestBody Character character) {
        return new ResponseEntity<>(characterService.updateCharacter(character), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteCharacter(@PathVariable("id") Long id) {
        return characterService.deleteCharacter(id)
                ? new ResponseEntity<>("Character " + id + " deleted succesfully", HttpStatus.OK)
                : new ResponseEntity<>("ERROR to delete Character " + id, HttpStatus.OK);
    }
}
