package menu.acoes;

import java.util.Scanner;

public abstract class InputAction<T> extends Action<T>{
    private final Scanner scanner;
    InputAction(String name, Scanner scanner) {
        super(name);
        this.scanner = scanner;
    }
}
