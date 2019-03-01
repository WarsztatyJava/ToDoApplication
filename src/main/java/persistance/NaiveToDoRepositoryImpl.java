package persistance;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import model.ToDo;

public class NaiveToDoRepositoryImpl implements ToDoRepository {

    private final Map<Long, ToDo> todos = new HashMap<>();
    private final HoleObservable holeObservable;

    public NaiveToDoRepositoryImpl(HoleObservable holeObservable) {
        this.holeObservable = holeObservable;
    }

    @Override
    public void add(ToDo toDo) {
        todos.put(toDo.getId(), toDo);
    }

    @Override
    public void change(long id, ToDo toDo) {
        todos.put(toDo.getId(), toDo);
    }

    @Override
    public void remove(long id) {
        todos.remove(id);
        holeObservable.updateSubscribers(id);
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
    }
}
