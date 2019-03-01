package gui;

import java.util.Collection;

import controlers.ToDoService;
import model.ToDo;

public class ToDoGui {

    private final ToDoService toDoService;
    private final InputProvider inputProvider;

    public ToDoGui(ToDoService toDoService, InputProvider inputProvider) {
        this.toDoService = toDoService;
        this.inputProvider = inputProvider;
    }

    public void showMenu() {
        System.out.println("Select Available option");
        System.out.println("1) Add ToDo");
        System.out.println("2) Remove ToDo");
        System.out.println("3) Change ToDo");
        System.out.println("4) Show All ToDos");

        GuiOption guiOption = GuiOption.getByCode(inputProvider.getNumber());
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
        String message = inputProvider.getText();
        toDoService.add(message);
    }

    private void remove() {
        int id = selectRemoveOption();
        toDoService.remove(id);
    }

    private void change() {
        int id = selectChangeOption();
        System.out.println("Put new text: ");
        String text = inputProvider.getText();
        toDoService.change(id, text);
    }

    private void show() {
        Collection<ToDo> toDos = toDoService.getAll();
        toDos.forEach(toDo -> showToDo(toDo));
    }

    private void showToDo(ToDo toDo) {
        System.out.println(toDo.getId() + " - " + toDo.getMessage());
    }

    private int selectRemoveOption() {
        System.out.println("Which to remove?");
        return inputProvider.getNumber();
    }

    private int selectChangeOption() {
        System.out.println("Which to change?");
        return inputProvider.getNumber();
    }
}
