package com.example.moviecharactersapihk.controllers;

import com.example.moviecharactersapihk.models.Character;
import com.example.moviecharactersapihk.models.Movie;
import com.example.moviecharactersapihk.services.character.CharacterService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/characters") // Base URL
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @Operation(summary = "Get all characters")
    @GetMapping // GET: localhost:8080/api/v1/characters
    public ResponseEntity<Collection<Character>> getAll() {
        return ResponseEntity.ok(characterService.findAll());
    }

    @Operation(summary = "Get character by id")
    @GetMapping("{id}") // GET: localhost:8080/api/v1/characters/1
    public ResponseEntity<Character> getById(@PathVariable int id) {
        return ResponseEntity.ok(characterService.findById(id));
    }

    @Operation(summary ="Create a new character")
    @PostMapping // POST: localhost:8080/api/v1/characters
    public ResponseEntity<Movie> add(@RequestBody Character character) {
        Character charAdd = characterService.add(character);
         character.getId();
        URI location = URI.create("characters/" + charAdd.getId());
        return ResponseEntity.created(location).build();
        // return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    // this needs to handle foreign key constraint
    @Operation(summary ="Delete a character by id")
    @DeleteMapping("{id}") // DELETE: localhost:8080/api/v1/movies/1
    public ResponseEntity<Movie> delete(@PathVariable int id) {
        characterService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
