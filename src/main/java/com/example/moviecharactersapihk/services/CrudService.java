package com.example.moviecharactersapihk.services;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

public interface CrudService <T, ID> {
    // Generic CRUD
    T findById(ID id);
    Collection<T> findAll();
    T add(T entity);
    T update(T entity);
    void deleteById(ID id);
    void delete(T entity);
}