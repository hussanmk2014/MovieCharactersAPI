package com.example.moviecharactersapihk.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 50)
    private String alias;
    @Column(length = 10)
    private String gender;
    @Column(length = 2083)
    private String picture;
    @ManyToMany(mappedBy = "characters")
    private Set<Movie> movies;


    public int getId() {
        return id;
    }


}
