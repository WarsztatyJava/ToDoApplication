import java.util.Scanner;

import gui.ToDoGui;
import persistance.NaiveToDoRepositoryImpl;
import persistance.ToDoRepository;

public class Application {

    public static void main(String[] args) {

        ToDoRepository toDoRepository = new NaiveToDoRepositoryImpl();
        ToDoGui toDoGui = new ToDoGui(toDoRepository);

        while (true){
            toDoGui.showMenu();
        }
    }
}
