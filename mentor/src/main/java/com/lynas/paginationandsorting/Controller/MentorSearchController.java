package com.lynas.paginationandsorting.Controller;
import com.lynas.paginationandsorting.Entity.MentorSearch;
import com.lynas.paginationandsorting.Repository.MentorSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MentorSearchController {
    private final MentorSearchRepository repository;
    @GetMapping("/students")
    public List<MentorSearch> findAll(
            @RequestParam Optional<String> name,
            @RequestParam Optional<String> sortBy) {
        // Sort by added
        return (List<MentorSearch>) repository.findByName(name.orElse("_"));

    }
}