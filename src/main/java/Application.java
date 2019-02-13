import java.util.Scanner;

import gui.ToDoGui;
import persistance.NaiveToDoRepositoryImpl;
import persistance.ToDoRepository;

public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ToDoRepository toDoRepository = new NaiveToDoRepositoryImpl();
        ToDoGui toDoGui = new ToDoGui(scanner, toDoRepository);

        while (true){
            toDoGui.showMenu();
        }
    }
}
