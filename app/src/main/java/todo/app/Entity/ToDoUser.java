package todo.app.Entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="to_do_user")
public class ToDoUser {
    @Id
    private Long id;

    private String userName;
    private String password;


    public ToDoUser(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ToDoUser(Long id, String userName, String password, List<ToDo> todoList) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
}
