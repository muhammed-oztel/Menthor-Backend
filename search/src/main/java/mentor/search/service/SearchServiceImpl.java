package mentor.search.service;
import mentor.search.entity.Mentor;
import mentor.search.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService{

    private SearchRepository searchRepository;


    public SearchServiceImpl(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    @Override
    public List<Mentor> searchMentor(String query){
        List<Mentor> mentors = searchRepository.searchMentor(query);
        return mentors;
    }

    @Override
    public Mentor createMentor(Mentor mentor) {
        return searchRepository.save(mentor);
    }
}
