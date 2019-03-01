package persistance;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import model.ToDo;

public class NaiveToDoRepositoryImpl implements ToDoRepository {

    private static final AtomicLong INITIAL = new AtomicLong(1);

    private final Map<Long, ToDo> todos = new HashMap<>();
    private AtomicLong counter = INITIAL;

    @Override
    public void add(ToDo toDo) {
        long counter = this.counter.getAndIncrement();
        toDo.setId(counter);
        todos.put(counter, toDo);
    }

    @Override
    public void change(long id, ToDo toDo) {
        todos.put(id, toDo);
    }

    @Override
    public void remove(long id) {
        todos.remove(id);
    }

    @Override
    public ToDo get(long id) {
        return todos.get(id);
    }

    @Override
    public Collection<ToDo> getAll() {
        return todos.values();
    }

    @Override
    public void removeAll() {
        todos.clear();
        counter = new AtomicLong(1);
    }
}
