package com.example.moviecharactersapihk.controllers;

import com.example.moviecharactersapihk.models.Character;
import com.example.moviecharactersapihk.models.Franchise;
import com.example.moviecharactersapihk.models.Movie;
import com.example.moviecharactersapihk.services.franchise.FranchiseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/franchises") // Base URL
public class FranchiseController {

    private final FranchiseService franchiseService;
    public FranchiseController(FranchiseService franchiseService) {
        this.franchiseService = franchiseService;
    }

    @GetMapping // GET: localhost:8080/api/v1/franchises
    public ResponseEntity<Collection<Franchise>> getAll() {
        return ResponseEntity.ok(franchiseService.findAll());
    }

    @GetMapping("{id}") // GET: localhost:8080/api/v1/franchises/1
    public ResponseEntity<Franchise> getById(@PathVariable int id) {
        return ResponseEntity.ok(franchiseService.findById(id));
    }

    @PostMapping // POST: localhost:8080/api/v1/franchises
    public ResponseEntity<Movie> add(@RequestBody Franchise franchise) {
        Franchise fran = franchiseService.add(franchise);
        franchise.getId();
        URI location = URI.create("franchises/" + fran.getId());
        return ResponseEntity.created(location).build();
        // return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // todo




}
