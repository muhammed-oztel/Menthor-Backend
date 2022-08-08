package com.lynas.paginationandsorting;
import com.lynas.paginationandsorting.Entity.MentorSearch;
import com.lynas.paginationandsorting.Repository.MentorSearchRepository;
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
    public CommandLineRunner init(MentorSearchRepository repository) {
        return args -> {
            repository.save(new MentorSearch(1, "sazzad"));
            repository.save(new MentorSearch(2, "Rony"));
            repository.save(new MentorSearch(3, "Naim"));
            repository.save(new MentorSearch(4, "Dania"));
            repository.save(new MentorSearch(5, "Mamun"));
            repository.save(new MentorSearch(6, "Rimi"));
            repository.save(new MentorSearch(7, "Habib"));
            repository.save(new MentorSearch(8, "Shail"));
            repository.save(new MentorSearch(9, "Pranjol"));
            repository.save(new MentorSearch(10, "Shohag"));
        };
    }
}




