package mentor.search.controller;
import mentor.search.entity.Mentor;
import mentor.search.service.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class SearchController {
    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Mentor>> searchMentors(String query){
        return ResponseEntity.ok(searchService.searchMentor(query));
    }

    @PostMapping
    public Mentor createMentor(@RequestBody Mentor mentor){
        return searchService.createMentor(mentor);
    }
}

