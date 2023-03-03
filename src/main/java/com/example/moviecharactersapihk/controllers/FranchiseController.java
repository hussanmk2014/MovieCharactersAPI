package com.example.moviecharactersapihk.controllers;

import com.example.moviecharactersapihk.models.Character;
import com.example.moviecharactersapihk.models.Franchise;
import com.example.moviecharactersapihk.models.Movie;
import com.example.moviecharactersapihk.services.franchise.FranchiseService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Get all franchises")
    @GetMapping // GET: localhost:8080/api/v1/franchises
    public ResponseEntity<Collection<Franchise>> getAll() {
        return ResponseEntity.ok(franchiseService.findAll());
    }

    @Operation(summary = "Get franchise by id")
    @GetMapping("{id}") // GET: localhost:8080/api/v1/franchises/1
    public ResponseEntity<Franchise> getById(@PathVariable int id) {
        return ResponseEntity.ok(franchiseService.findById(id));
    }

    @Operation(summary ="Create a new franchise")
    @PostMapping // POST: localhost:8080/api/v1/franchises
    public ResponseEntity<Movie> add(@RequestBody Franchise franchise) {
        Franchise fran = franchiseService.add(franchise);
        franchise.getId();
        URI location = URI.create("franchises/" + fran.getId());
        return ResponseEntity.created(location).build();
        // return ResponseEntity.status(HttpStatus.CREATED).build();
    }






}
