package com.example.moviecharactersapihk.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class MovieNotFoundException  extends RuntimeException {
        public MovieNotFoundException(int id) {
            super("Student does not exist with ID: " + id);
        }
        // Generated constructors omitted
    }

