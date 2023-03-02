package com.example.moviecharactersapihk.services.movie;

import com.example.moviecharactersapihk.models.Movie;
import com.example.moviecharactersapihk.repositories.MoviesRepository;
import com.example.moviecharactersapihk.services.character.CharacterServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MovieServiceImpl implements MovieService{



    private final MoviesRepository moviesRepository;

    public MovieServiceImpl(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    private final Logger logger = LoggerFactory.getLogger(CharacterServiceImpl.class);


    @Override
    public Movie findById(Integer id) {
        return moviesRepository.findById(id).get();
    }

    @Override
    public Collection findAll() {
        return moviesRepository.findAll();
    }

    @Override
    public Movie add(Movie movie) {
        return  moviesRepository.save(movie);
    }

    @Override // This method needs to be updated correctly
    public Movie update(Movie movie) {

        Movie updMovie = moviesRepository.findById(movie.getId()).get();

        updMovie.setTitle(movie.getTitle());
        updMovie.setDirector(movie.getDirector());


        return moviesRepository.save(updMovie);
    }

    @Override
    public void deleteById(Integer id) {
         moviesRepository.deleteById(id);
    }
    @Override
    public void delete(Movie entity) {

    }
}
