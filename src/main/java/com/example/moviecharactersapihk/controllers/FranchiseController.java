package com.example.moviecharactersapihk.controllers;

import com.example.moviecharactersapihk.dtos.FranchiseDTO;
import com.example.moviecharactersapihk.mappers.FranchiseMapper;
import com.example.moviecharactersapihk.models.Franchise;
import com.example.moviecharactersapihk.services.franchise.FranchiseService;
import com.example.moviecharactersapihk.utils.ApiErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/franchises")
public class FranchiseController {
    private final FranchiseService franchiseService;
    private final FranchiseMapper franchiseMapper;

    public FranchiseController(FranchiseService franchiseService, FranchiseMapper franchiseMapper) {

        this.franchiseService = franchiseService;
        this.franchiseMapper = franchiseMapper;
    }

    @Operation(summary = "Get all franchises")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Bad request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })


    @GetMapping
    public ResponseEntity findAll() {

        Collection<Franchise> franchises = franchiseService.findAll();
        return ResponseEntity.ok(franchiseMapper.franchiseToFranchiseDto(franchises));
    }

    @Operation(summary = "Get a franchise by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Franchise doesn't exist with supplied ID",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable int id) {

        FranchiseDTO franchise = franchiseMapper.franchiseToFranchiseDto(franchiseService.findById(id));
        return ResponseEntity.ok(franchise);
    }

    @Operation(summary = "add a franchise")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "204",
                    description = "Franchise successfully added",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })

    @PostMapping
    public ResponseEntity add(@RequestBody Franchise fran) {
        Franchise newFran = franchiseService.add(fran);
        URI uri = URI.create("franchises/" + newFran.getId());
        return ResponseEntity.created(uri).build();
    }

    @ApiResponses( value = {
            @ApiResponse(responseCode = "204",
                    description = "Franchise is successfully updated",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Franchise is not found with supplied ID",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
    })
    @Operation(summary = "update a franchise")
    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody FranchiseDTO franchiseDTO, @PathVariable int id) {
        if(franchiseDTO.getId() != id)
            return ResponseEntity.badRequest().build();
        franchiseService.update(franchiseMapper.franchiseDtoToFranchise(franchiseDTO));
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "update movies with selected franchise")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "204",
                    description = "Movies of selected franchise successfully updated",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Franchise not found with supplied ID",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })

    })
    @PutMapping("updateFranchiseMovie/{id}")
    public ResponseEntity updateFrachisesMoviesById(@RequestBody ArrayList<Integer> movieIDs, @PathVariable int id) {
        if(franchiseService.findById(id) == null){
            return ResponseEntity.badRequest().build();
        }

        franchiseService.updateFrachisesMoviesById(id, movieIDs);
        return ResponseEntity.noContent().build();
    }

}
