package com.example.moviecharactersapihk.mappers;

import com.example.moviecharactersapihk.dtos.FranchiseDTO;
import com.example.moviecharactersapihk.models.Franchise;
import com.example.moviecharactersapihk.services.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;

import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class FranchiseMapper {

    @Autowired
    protected MovieService movieService;

    public abstract FranchiseDTO franchiseToFranchiseDto(Franchise franchise);

    public abstract Collection<FranchiseDTO> franchiseToFranchiseDto(Collection<Franchise> franchises);

    @Mapping(target = "movies", ignore = true)
    public abstract Franchise franchiseDtoToFranchise(FranchiseDTO dto);

}
