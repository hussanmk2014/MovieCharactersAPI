package com.example.moviecharactersapihk.services.franchise;

import com.example.moviecharactersapihk.models.Character;
import com.example.moviecharactersapihk.models.Franchise;
import com.example.moviecharactersapihk.models.Movie;
import com.example.moviecharactersapihk.repositories.CharacterRepository;
import com.example.moviecharactersapihk.repositories.FranchiseRepository;
import com.example.moviecharactersapihk.services.character.CharacterServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Service
public class FranchiseServiceImpl implements FranchiseService{



    private final FranchiseRepository franchiseRepository;
    private final Logger logger = LoggerFactory.getLogger(CharacterServiceImpl.class);

    public FranchiseServiceImpl(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }

    @Override
    public Franchise findById(Integer id) {
        return franchiseRepository.findById(id).get();
    }

    @Override
    public Collection findAll() {
        return franchiseRepository.findAll();
    }

    @Override
    public Franchise add(Franchise franchise) {
        return  franchiseRepository.save(franchise);
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
