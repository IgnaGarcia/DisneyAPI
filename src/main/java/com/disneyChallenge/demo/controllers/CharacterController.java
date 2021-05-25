package com.disneyChallenge.demo.controllers;

import com.disneyChallenge.demo.models.Character;
import com.disneyChallenge.demo.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/character")
public class CharacterController {
    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) { this.characterService = characterService; }

    @GetMapping
    public List<Character> getCharacters(){ return characterService.getCharacters(); }
}
