package com.example.moviecharactersapihk.services.franchise;

import com.example.moviecharactersapihk.models.Franchise;
import com.example.moviecharactersapihk.models.Movie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class FranchiseServiceImpl implements FranchiseService{
    @Override
    public Franchise findById(Integer integer) {
        return null;
    }

    @Override
    public Collection<Franchise> findAll() {
        return null;
    }

    @Override
    public Franchise add(Franchise entity) {
        return null;
    }

    @Override
    public Franchise update(Franchise entity) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Franchise entity) {

    }


    @Override
    public void updateFranchisesMoviesById(int franchise_id, Set<Movie> movies) {

    }

    @Override
    public void updateFrachisesMoviesById(int franchise_id, ArrayList<Integer> movieIDs) {

    }
}
