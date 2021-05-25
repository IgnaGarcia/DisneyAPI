package com.disneyChallenge.demo.services;

import com.disneyChallenge.demo.models.Character;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CharacterService {

    public List<Character> getCharacters() {
        return List.of(
                new Character()
        );
    }
}
