package com.example.moviecharactersapihk.services.franchise;

import com.example.moviecharactersapihk.models.Franchise;
import com.example.moviecharactersapihk.models.Movie;
import com.example.moviecharactersapihk.repositories.FranchiseRepository;
import com.example.moviecharactersapihk.services.movie.MovieService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class FranchiseServiceImpl implements FranchiseService{

    private final Logger logger = LoggerFactory.getLogger(FranchiseServiceImpl.class);
    private final FranchiseRepository franchiseRepository;
    private final MovieService movieservice;

    public FranchiseServiceImpl(FranchiseRepository franchiseRepository, MovieService movieservice) {
        this.franchiseRepository = franchiseRepository;
        this.movieservice = movieservice;
    }
    @Override
    public Franchise findById(Integer id) {
        return franchiseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());

    }

    @Override
    public Collection<Franchise> findAll() {
        return franchiseRepository.findAll();
    }

    @Override
    public Franchise add(Franchise entity) {
        return franchiseRepository.save(entity);
    }

    @Override
    public Franchise update(Franchise entity) {

        return franchiseRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        if(franchiseRepository.existsById(id)) {
            Franchise fr = franchiseRepository.findById(id).get();
            fr.getMovies().forEach(m -> m.setFranchise(null));
            franchiseRepository.delete(fr);
        }
        else
            logger.warn("No franchise exists with ID: " + id);
    }

    @Override
    public void delete(Franchise entity) {

    }

    @Override
    public boolean exists(Integer id) {
        return franchiseRepository.existsById(id);
    }

    @Transactional
    @Override
    public void updateFrachisesMoviesById(int franchise_id, ArrayList<Integer> movieIDs){
        Franchise fr = franchiseRepository.findById(franchise_id).get();
        ArrayList<Movie> movies = new ArrayList<>();
        for(int i : movieIDs){
            movies.add(movieservice.findById(i));
        }

        fr.setMovies(movies.stream().collect(Collectors.toSet()));

    }
}

