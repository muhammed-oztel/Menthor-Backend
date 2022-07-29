package mentor.search.service;

import mentor.search.entity.Mentor;

import java.util.List;

public interface SearchService {
    List<Mentor> searchMentor(String query);

    Mentor createMentor(Mentor mentor);
}
