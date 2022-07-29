package com.lynas.paginationandsorting;

import com.lynas.paginationandsorting.Student;
import com.lynas.paginationandsorting.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentRepository repository;

    @GetMapping("/students")
    public Page<Student> findAll(
            @RequestParam Optional<String> name,
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<String> sortBy) {
        // Sort by added
        return repository.findByName(name.orElse("_"),
                new PageRequest(
                        page.orElse(0), 5,
                        Sort.Direction.ASC, sortBy.orElse("id")));
    }
}