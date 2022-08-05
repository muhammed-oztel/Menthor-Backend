package quiz.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quiz.app.model.Question;


@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {

}