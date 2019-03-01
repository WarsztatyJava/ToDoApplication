import java.util.Scanner;

import gui.InputProvider;

public class InputProviderImpl implements InputProvider {

    @Override
    public String getText() {
        return getScanner().nextLine();
    }

    @Override
    public int getNumber() {
        return getScanner().nextInt();
    }

    private Scanner getScanner() {
        return new Scanner(System.in);
    }
}