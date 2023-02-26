package com.example.moviecharactersapihk.models;

import jakarta.persistence.*;
@Entity
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 2000)
    private String description;

}