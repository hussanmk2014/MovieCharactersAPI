package com.example.moviecharactersapihk.repositories;

import com.example.moviecharactersapihk.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MoviesRepository extends JpaRepository<Movie, Integer> {
    @Query("select m from Movie m where m.franchise=?1")
    Set<Movie> findAllByFranchise(int franchise_id);


}

