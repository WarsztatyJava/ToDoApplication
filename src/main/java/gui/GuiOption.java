package gui;

import java.util.stream.Stream;

public enum GuiOption {
    ADD(1), REMOVE(2), CHANGE(3), SHOW(4);

    private int code;

    GuiOption(int code) {
        this.code = code;
    }

    public static GuiOption getByCode(int code) {
        return Stream.of(GuiOption.values())
                     .filter(option -> option.code == code)
                     .findFirst()
                     .orElseThrow(UnsupportedOperationException::new);
    }
}
