package persistance;

import java.util.Collection;

import model.ToDo;

public interface ToDoRepository {

    void add(ToDo toDo);
    void change(long id, ToDo toDo);
    void remove(long id);
    ToDo get(long id);
    Collection<ToDo> getAll();
    void removeAll();

}
