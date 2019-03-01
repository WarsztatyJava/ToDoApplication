package controlers;

import java.util.Collection;

import model.ToDo;

public interface ToDoService {
    void add(String text);
    void remove (int number);
    void change (int number, String text);
    Collection <ToDo> getAll();
}
