import controlers.ToDoService;
import controlers.ToDoServiceImpl;
import controlers.TodoFactoryPatern;
import gui.InputProvider;
import gui.ToDoGui;
import persistance.NaiveToDoRepositoryImpl;
import persistance.ToDoRepository;

public class Application {

    public static void main(String[] args) {

        ToDoRepository toDoRepository = new NaiveToDoRepositoryImpl();
        TodoFactoryPatern todoFactory = new TodoFactoryPatern(toDoRepository);
        ToDoService toDoService = new ToDoServiceImpl(toDoRepository, todoFactory);
        InputProvider inputProvider = new InputProviderImpl();
        ToDoGui toDoGui = new ToDoGui(toDoService, inputProvider);

        while (true) {
            toDoGui.showMenu();
        }
    }
}
