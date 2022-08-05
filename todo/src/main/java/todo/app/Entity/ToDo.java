package todo.app.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="to_do")
public class ToDo {

    @Id
    private Long id;
    private String content;
    private Boolean completed = Boolean.FALSE;

    public ToDo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public ToDo(Long id, String content, Boolean completed) {
        this.id = id;
        this.content = content;
        this.completed = completed;
    }
}
