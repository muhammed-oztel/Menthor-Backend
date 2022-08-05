package todo.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.app.Entity.ToDo;


public interface ToDoRepository extends JpaRepository<ToDo,Long> {
}
