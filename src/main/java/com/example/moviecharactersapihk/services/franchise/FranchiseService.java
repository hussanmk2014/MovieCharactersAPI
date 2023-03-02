package com.example.moviecharactersapihk.services.franchise;

import com.example.moviecharactersapihk.models.Franchise;
import com.example.moviecharactersapihk.models.Movie;
import com.example.moviecharactersapihk.services.CrudService;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.Set;


public interface FranchiseService extends CrudService<Franchise, Integer> {
    @Transactional
    void updateFrachisesMoviesById(int franchise_id, ArrayList<Integer> movieIDs);

    @Modifying
    @Query("update Franchise fr set fr.movies = ?2 where fr.id = ?1")
    void updateFranchisesMoviesById(int franchise_id, Set<Movie> movies);

}
