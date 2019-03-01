package gui;

import java.util.Scanner;

import model.ToDo;
import persistance.ToDoRepository;

public class ToDoGui {

    private final ToDoRepository toDoRepository;

    public ToDoGui(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public void showMenu() {
        System.out.println("Select Available option");
        System.out.println("1) Add ToDo");
        System.out.println("2) Change ToDo");
        System.out.println("3) Remove ToDo");
        System.out.println("4) Show All ToDos");

        GuiOption guiOption = GuiOption.getByCode(getInputFromUser());
        selectMainOption(guiOption);
    }

    private void selectMainOption(GuiOption guiOption) {
        switch (guiOption) {
            case ADD:
                add();
                break;
            case REMOVE:
                remove();
                break;
            case CHANGE:
                change();
                break;
            case SHOW:
                show();
                break;
        }
    }

    private void add() {
        System.out.println("Give me text");
        String message = new Scanner(System.in).nextLine();
        ToDo todo = new ToDo(message);
        toDoRepository.add(todo);

    }

    private void remove() {
        int id = selectRemoveOption();
        toDoRepository.remove(id);
    }

    private void change() {
        int id = selectChangeOption();
        //    todo: implement    toDoRepository.change(id);
    }

    private void show() {
        int id = selectShowOption();
        ToDo toDo = toDoRepository.get(id);
        System.out.println(toDo.getMessage());

    }

    private int selectShowOption() {
        System.out.println("Which to show?");
        return getInputFromUser();
    }

    private int selectRemoveOption() {
        System.out.println("Which to remove?");
        return getInputFromUser();
    }

    private int selectChangeOption() {
        System.out.println("Which to change?");
        return getInputFromUser();
    }

    private int getInputFromUser() {
        return new Scanner(System.in).nextInt();
    }
}
