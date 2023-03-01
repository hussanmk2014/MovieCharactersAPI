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

        //characterService.deleteById(3);

       /* Character a =characterService.findById(2);
        a.setName("dfg");

        characterService.update(a);

        characterService.deleteById(1 );
        characterService.findAllCharactersByFranchise(3).stream().forEach(c -> System.out.println(c.getName()));

        Set<Character> c = characterService.findAllCharactersByFranchise(3);*/

        System.out.println((characterRepository.findAll()));
        //characterService.findAllCharactersByFranchise(3).stream().forEach(c -> System.out.println(c.getName()));
       // characterService.deleteById(1);
        //Character newStudent = new Character();
       // newStudent.setName("John Smith");
        //add(newStudent);
    }

    //public void add(Character Character) {
    //    characterRepository.save(Character);
    //    System.out.println("Stud ID:" + Character.getId());
  //  }
}