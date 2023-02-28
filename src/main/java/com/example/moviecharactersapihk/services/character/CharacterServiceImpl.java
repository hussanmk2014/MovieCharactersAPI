package com.example.moviecharactersapihk.services.character;

import com.example.moviecharactersapihk.models.Character;
import com.example.moviecharactersapihk.models.Movie;
import com.example.moviecharactersapihk.repositories.CharacterRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Service
public class CharacterServiceImpl implements CharacterService{

    private final Logger logger = LoggerFactory.getLogger(CharacterServiceImpl.class);
    private final CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;

    }
    @Override
    public Character findById(Integer id) {
        return characterRepository.findById(id).get();
    }

    @Override
    public Collection<Character> findAll() {
        return characterRepository.findAll();
    }

    @Override
    public Character add(Character entity) {
        return characterRepository.save(entity);
    }

    @Override
    public Character update(Character entity) {

        return characterRepository.save(entity);
    }
    @Transactional
    @Override
    public void deleteById(Integer id) {
        if(characterRepository.existsById(id)) {
            Character character = characterRepository.findById(id).get();
            for(Movie movie : character.getMovies()){
                movie.getCharacters().remove(character);
                character.getMovies().remove(movie);
            }

            characterRepository.delete(character);
        }
        else
            logger.warn("No character exists with ID: " + id);
    }

    @Override
    public void delete(Character entity) {

    }


    @Override
    public boolean exists(Integer id) {
        return characterRepository.existsById(id);
    }

    @Override
    public Set<Character> findAllCharactersByFranchise(Integer id){
        return characterRepository.findAllCharactersByFranchise(id);
    }



}
