package com.example.moviecharactersapihk.repositories;

import com.example.moviecharactersapihk.models.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {
    @Query(value = "select distinct * from character " +
            "inner join movie_character  on character.id = movie_character.character_id  " +
            "inner join movie on movie_character.movie_id=movie.id " +
            " inner join franchise on franchise.id=movie.franchise_id " +
            "where franchise.id = ?1 ", nativeQuery = true)
    Set<Character> findAllCharactersByFranchise(int franchiseId);
    Optional<Character> findFirstByNameIsContaining(String name);
}