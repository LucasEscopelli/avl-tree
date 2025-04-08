package menu.actions.abstractactions;

import menu.actions.ActionStatus;
import tree.Tree;

import java.util.Scanner;
import java.util.function.Consumer;

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
