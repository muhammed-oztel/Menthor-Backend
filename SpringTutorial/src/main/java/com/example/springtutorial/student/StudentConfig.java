package com.example.springtutorial.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student oguz = new Student(
                    "Oguz",
                    "oguz.ozturk.tedu@gmail.com",
                    LocalDate.of(2000, Month.JANUARY,12)

            );

            Student ahmet = new Student(
                    "Ahmet",
                    "Ahmet@gmail.com",
                    LocalDate.of(2000, Month.FEBRUARY,15)

            );

            repository.saveAll(
                    List.of(oguz,ahmet)
            );
        };
    }
}
