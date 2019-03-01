package controlers;


import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import model.ToDo;
import persistance.Observer;
import persistance.ToDoRepository;

public class TodoFactoryPatern implements Observer {

    private final ToDoRepository toDoRepository;
    private final Set<Long> holes = new TreeSet(Comparator.naturalOrder());
    private long counter = 1L;

    public TodoFactoryPatern(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public ToDo produceToDo(String text) {
        Long id = holes.stream()
                       .findFirst()
                       .orElse(counter++);
        return new ToDo(id, text);
    }

    @Override
    public void update(long id) {
        holes.add(id);
    }
}
