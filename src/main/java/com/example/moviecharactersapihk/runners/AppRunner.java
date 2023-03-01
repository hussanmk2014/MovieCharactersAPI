package com.example.moviecharactersapihk.runners;

import com.example.moviecharactersapihk.repositories.CharacterRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class AppRunner implements ApplicationRunner {

    private final CharacterRepository characterRepository;

    public AppRunner( CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        System.out.println((characterRepository.findAll()));
        System.out.println(characterRepository
                .findById(1).get());

        System.out.println(characterRepository.findById(1).get().getName());

}

}