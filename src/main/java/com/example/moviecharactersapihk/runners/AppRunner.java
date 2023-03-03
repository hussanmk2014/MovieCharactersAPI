package com.example.moviecharactersapihk.runners;

import com.example.moviecharactersapihk.repositories.CharacterRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class AppRunner implements ApplicationRunner {
    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

}
}