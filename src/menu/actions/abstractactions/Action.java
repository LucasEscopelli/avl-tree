package menu.actions.abstractactions;

import java.util.Scanner;
import java.util.function.Consumer;

public abstract class Action<T> implements Consumer<T> {
    private String name;
    protected final Scanner scanner;
    protected Action(String name, Scanner scanner){
        this.name = name;
        this.scanner = scanner;
    }

    public String getName() {
        return name;
    }
}
