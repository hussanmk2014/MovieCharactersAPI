package com.example.moviecharactersapihk.services.movie;


import com.example.moviecharactersapihk.models.Character;

import com.example.moviecharactersapihk.models.Movie;
import com.example.moviecharactersapihk.services.CrudService;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.Set;

public interface MovieService  extends CrudService<Movie, Integer> {
    public Set<Character> getAllCharactersInMovie(Integer id);
    public void updateMoviesCharactersById(int movieId, ArrayList<Integer> characterIDs);

}
