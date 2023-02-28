package com.example.moviecharactersapihk.services.movie;

import com.example.moviecharactersapihk.models.Movie;
import com.example.moviecharactersapihk.repositories.CharacterRepository;
import com.example.moviecharactersapihk.repositories.MovieRepository;
import com.example.moviecharactersapihk.services.character.CharacterServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;
    private final Logger logger = LoggerFactory.getLogger(CharacterServiceImpl.class);

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Override
    public Movie findById(Integer id) {
        return movieRepository.findById(id).get();
    }

    @Override
    public Collection findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie add(Movie movie) {
        return  movieRepository.save(movie);
    }

    @Override // This method needs to be updated correctly
    public Movie update(Movie movie) {

        Movie updMovie = movieRepository.findById(movie.getId()).get();

        updMovie.setTitle(movie.getTitle());
        updMovie.setDirector(movie.getDirector());


        return movieRepository.save(updMovie);
    }

    @Override
    public void deleteById(Integer id) {
         movieRepository.deleteById(id);
    }
    @Override
    public void delete(Movie entity) {

    }
}
