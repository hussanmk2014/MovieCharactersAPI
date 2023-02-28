package com.example.moviecharactersapihk.services.character;

import com.example.moviecharactersapihk.models.Character;
import com.example.moviecharactersapihk.services.CrudService;

import java.util.Set;

public interface CharacterService extends CrudService<Character,Integer> {

    public Set<Character> findAllCharactersByFranchise(Integer id);

}
