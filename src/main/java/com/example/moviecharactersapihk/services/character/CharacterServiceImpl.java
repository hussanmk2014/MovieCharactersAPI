package com.example.moviecharactersapihk.services.character;

import com.example.moviecharactersapihk.models.Character;
import com.example.moviecharactersapihk.repositories.CharacterRepository;
import com.example.moviecharactersapihk.services.character.CharacterService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository characterRepository;
    private final Logger logger = LoggerFactory.getLogger(CharacterServiceImpl.class);

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public Character findById(Integer id) {
        return characterRepository.findById(id).get();
    }


    @Override
    public Collection<Character> findAll() {
     return  characterRepository.findAll();
    }

    @Override
    public Character add(Character character) {
        return characterRepository.save(character);
    }

    @Override
    public Character update(Character entity) {
        return null;
    }

    // this needs to handle foreign key constraint
    @Override
    public void deleteById(Integer id) {
        characterRepository.deleteById(id);
    }

    @Override
    public void delete(Character entity) {

    }


    @Override
    public Set<Character> findAllCharactersByFranchise(Integer id) {
        return null;
    }
}