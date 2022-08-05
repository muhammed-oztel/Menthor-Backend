package todo.app.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import todo.app.Entity.ToDoUser;
import todo.app.Repository.ToDoRepository;
import todo.app.Repository.ToDoUserRepo;


import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class TodoUserController {

    private ToDoUserRepo toDoUserRepo;
    private ToDoRepository toDoRepository;

    public TodoUserController(ToDoUserRepo toDoUserRepo, ToDoRepository toDoRepository) {
        this.toDoUserRepo = toDoUserRepo;
        this.toDoRepository = toDoRepository;
    }

    @GetMapping("/{userId}")
    public ToDoUser getUserById(@PathVariable Long userId) {
        return toDoUserRepo.findById(userId).orElseThrow(() -> new NoSuchElementException());
    }

}
