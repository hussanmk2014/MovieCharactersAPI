package com.example.moviecharactersapihk.repositories;

import com.example.moviecharactersapihk.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
