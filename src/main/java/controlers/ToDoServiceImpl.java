package controlers;

import java.util.Collection;

import model.ToDo;
import persistance.ToDoRepository;

public class ToDoServiceImpl implements ToDoService {
    private final ToDoRepository toDoRepository;
    private final TodoFactoryPatern todoFactory;

    public ToDoServiceImpl(ToDoRepository toDoRepository, TodoFactoryPatern todoFactory) {
        this.toDoRepository = toDoRepository;
        this.todoFactory = todoFactory;
    }

    @Override
    public void add(String text) {
        toDoRepository.add(todoFactory.produceToDo(text));
    }

    @Override
    public void remove(int number) {
        toDoRepository.remove(number);
    }

    @Override
    public void change(int number, String text) {
        toDoRepository.change(number, new ToDo(number, text));
    }

    @Override
    public Collection<ToDo> getAll() {
        return toDoRepository.getAll();
    }
}
