package menu.actions;

import menu.actions.abstractactions.Action;
import tree.Tree;

import java.util.Scanner;
import java.util.function.Consumer;

public class CloseApplicationAction <T> extends Action<Tree<T>> {
    public CloseApplicationAction(String name, Scanner scanner) {
        super(name, scanner);
    }

    @Override
    public ActionStatus runAction(Tree<T> tree) {
        System.out.println("Encerrando aplicação...");
        return ActionStatus.CLOSE_APPLICATION;
    }
}
