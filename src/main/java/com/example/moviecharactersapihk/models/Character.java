package com.example.moviecharactersapihk.models;

import jakarta.persistence.*;


import java.util.Set;

@Entity
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

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", gender='" + gender + '\'' +
                ", picture='" + picture + '\'' +
                ", movies=" + movies +
                '}';
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "character_movie",
            joinColumns = {@JoinColumn(name = "character_id")},
            inverseJoinColumns = {@JoinColumn(name = "movie_id")}
    )
    private Set<Movie> movies;

    public String getAlias() {
        return alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

/*
    public Movie getMovies() {
        return (Movie) movies;
    }

    public void setMovies(Movie movies) {
        this.movies = (Set<Movie>) movies;
   }*/
}