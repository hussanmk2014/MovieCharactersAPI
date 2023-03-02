package com.example.moviecharactersapihk.services.movie;

import com.example.moviecharactersapihk.exceptions.MovieNotFoundException;
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

    private final Logger logger = LoggerFactory.getLogger(CharacterServiceImpl.class);

    public MovieServiceImpl(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }


    @Override
    public Movie findById(Integer id) {
        System.out.println("ge" + id);
        return moviesRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
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

/*      Movie updMovie = moviesRepository.findById(movie.getId()).get();

        updMovie.setTitle(movie.getTitle());
        updMovie.setDirector(movie.getDirector());*/


        return moviesRepository.save(movie);
    }

    @Override
    public void deleteById(Integer id) {
         moviesRepository.deleteById(id);
    }
    @Override
    public void delete(Movie entity) {

    }
}
