package com.example.moviecharactersapihk.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class FranchiseDTO {
    private int id;
    private String name;
    private String description;
}
