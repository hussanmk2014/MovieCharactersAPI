package com.example.moviecharactersapihk.repositories;

import com.example.moviecharactersapihk.models.Franchise;
import com.example.moviecharactersapihk.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise,Integer> {
    @Modifying
    @Query("update Franchise fr set fr.movies = ?2 where fr.id = ?1")
    void updateFranchisesMoviesById(int franchise_id, Set<Movie> movies);
}
