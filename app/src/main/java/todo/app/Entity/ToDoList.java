package todo.app.Entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="to_do_user_to_do_list")
public class ToDoList {
    @Id
    @OneToMany
    private List<ToDo> todoList = new ArrayList<>();

    public ToDoList() {
    }

    public ToDoList(List<ToDo> todoList) {
        this.todoList = todoList;
    }

    public List<ToDo> getTodoList() {
        return todoList;
    }
    public void setTodoList(List<ToDo> todoList) {
        this.todoList = todoList;
    }
}
