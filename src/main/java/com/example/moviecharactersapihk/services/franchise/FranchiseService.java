package com.example.moviecharactersapihk.services.franchise;

import com.example.moviecharactersapihk.models.Franchise;
import com.example.moviecharactersapihk.services.CrudService;

import java.util.ArrayList;

public interface FranchiseService extends CrudService<Franchise, Integer> {
    void updateFrachisesMoviesById(int franchise_id, ArrayList<Integer> movieIDs);
}
