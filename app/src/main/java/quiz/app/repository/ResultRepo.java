package quiz.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quiz.app.model.Result;

@Repository
public interface ResultRepo extends JpaRepository<Result, Integer> {
	
}
