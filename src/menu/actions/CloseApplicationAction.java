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
    public void accept(Tree<T> tTree) {
        System.out.println("Encerrando aplicação...");
        System.exit(0);
    }

    @Override
    public Consumer<Tree<T>> andThen(Consumer<? super Tree<T>> after) {
        return super.andThen(after);
    }
}
