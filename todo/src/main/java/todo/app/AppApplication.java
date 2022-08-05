package todo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import todo.app.Entity.ToDo;
import todo.app.Entity.ToDoList;
import todo.app.Entity.ToDoUser;
import todo.app.Repository.ToDoRepository;
import todo.app.Repository.ToDoUserRepo;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	@Autowired
	private ToDoUserRepo toDoUserRepo;

	@Autowired
	private ToDoRepository toDoRepository;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ToDoUser user = new ToDoUser();
		user.setId(1L);
		user.setPassword("aaaa");
		user.setUserName("isim");

		ToDo todo = new ToDo();
		todo.setId(1L);
		todo.setContent("upload a video");

		ToDoList list = new ToDoList();

		list.getTodoList().add(todo);
		//user.getTodoList().add(todo);

		toDoRepository.save(todo);
		toDoUserRepo.save(user);


	}
}
