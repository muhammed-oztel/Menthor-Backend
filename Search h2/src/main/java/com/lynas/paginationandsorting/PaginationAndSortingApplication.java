package com.lynas.paginationandsorting;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PaginationAndSortingApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaginationAndSortingApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(StudentRepository repository) {
        return args -> {
            repository.save(new Student(1, "sazzad"));
            repository.save(new Student(2, "Rony"));
            repository.save(new Student(3, "Naim"));
            repository.save(new Student(4, "Dania"));
            repository.save(new Student(5, "Mamun"));
            repository.save(new Student(6, "Rimi"));
            repository.save(new Student(7, "Habib"));
            repository.save(new Student(8, "Shail"));
            repository.save(new Student(9, "Pranjol"));
            repository.save(new Student(10, "Shohag"));
        };
    }
}




