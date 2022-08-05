package todo.app.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import todo.app.Entity.ToDoUser;

public interface ToDoUserRepo extends JpaRepository<ToDoUser,Long> {
}
