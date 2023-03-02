package com.example.moviecharactersapihk.runners;

import com.example.moviecharactersapihk.repositories.CharacterRepository;
import com.example.moviecharactersapihk.services.character.CharacterService;
import com.example.moviecharactersapihk.services.movie.MovieService;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;



@Getter
@Setter
@Component
public class AppRunner implements ApplicationRunner {

    private final CharacterRepository characterRepository;
    private final CharacterService characterService;
    private final MovieService movieService;


    public AppRunner(CharacterRepository characterRepository, CharacterService characterService, MovieService movieService) {
        this.characterRepository=characterRepository;
        this.characterService = characterService;
        this.movieService = movieService;

    }
    
    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        System.out.println((characterRepository.findAll()));

        System.out.println(characterRepository
                .findById(1).get());
        System.out.println(characterRepository.findById(1).get().getName());
        System.out.println(characterRepository.findById(1).get().getMovies());


        System.out.println((characterRepository.findById(2).get().getMovies()));
      
    }
}

