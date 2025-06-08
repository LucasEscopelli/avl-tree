package menu.actions.abstractactions;

import menu.actions.ActionStatus;

import java.util.Scanner;

public abstract class Action<T> {
    private String name;
    protected final Scanner scanner;
    protected Action(String name, Scanner scanner){
        this.name = name;
        this.scanner = scanner;
    }

    public abstract ActionStatus runAction(T tree);

    public String getName() {
        return name;
    }
}
