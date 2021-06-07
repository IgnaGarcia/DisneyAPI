package com.disneyChallenge.demo.util;

import com.disneyChallenge.demo.models.Character;

import java.util.ArrayList;
import java.util.List;


public class CharacterDTO {
        public Long c_id;
        public String name;
        public String image;

        public CharacterDTO(Character character){
                this.c_id = character.getC_id();
                this.name = character.getName();
                this.image = character.getImage();
        }

        public static List<CharacterDTO> mapToDTO(List<Character> characterList){
                List<CharacterDTO> list = new ArrayList<>();
                for (Character c : characterList){
                        list.add(new CharacterDTO(c));
                }
                return list;
        }
}
