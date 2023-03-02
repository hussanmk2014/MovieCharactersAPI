package com.example.moviecharactersapihk.services.movie;

import com.example.moviecharactersapihk.models.Character;
import com.example.moviecharactersapihk.models.Movie;
import com.example.moviecharactersapihk.repositories.MoviesRepository;

import com.example.moviecharactersapihk.services.character.CharacterService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService{

    private final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);
    private final MoviesRepository movieRepository;
    private final CharacterService characterService;



    public MovieServiceImpl(MoviesRepository movieRepository, CharacterService characterService) {
        this.movieRepository = movieRepository;
        this.characterService = characterService;
    }
    @Override
    public Movie findById(Integer id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());

    }

    @Override
    public Collection<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie add(Movie entity) {
        return movieRepository.save(entity);
    }

    @Override
    public Movie update(Movie entity) {

        return movieRepository.save(entity);
    }
    @Transactional
    @Override
    public void deleteById(Integer id) {
        if(movieRepository.existsById(id)) {
            Movie movie = movieRepository.findById(id).get();
            movie.getCharacters().remove(movie);
            movieRepository.delete(movie);
        }
        else
            logger.warn("No movie exists with ID: " + id);
    }

    @Override
    public void delete(Movie entity) {

    }


    @Override
    public boolean exists(Integer id) {
        return movieRepository.existsById(id);
    }

    @Transactional
    @Override
    public Set<Character> getAllCharactersInMovie(Integer id) {
        if(movieRepository.existsById(id)) {
            Movie movie = movieRepository.findById(id).get();
            return movie.getCharacters();
        }
        else
            logger.warn("No movie exists with ID: " + id);
        return null;

    }
    @Transactional
    @Override
    public void updateMoviesCharactersById(int movieId, ArrayList<Integer> characterIDs){
        Movie movie = movieRepository.findById(movieId).get();
        ArrayList<Character> characters = new ArrayList<>();
        for(int i : characterIDs){
            characters.add(characterService.findById(i));
        }

        movie.setCharacters(characters.stream().collect(Collectors.toSet()));

    }


}