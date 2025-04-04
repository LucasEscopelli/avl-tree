package menu.actions;

import menu.actions.abstractactions.Action;
import printers.interfaces.TreePrinter;
import tree.Tree;

import java.util.Scanner;
import java.util.function.Consumer;

public class PrintAction <T> extends Action<Tree<T>> {
    private TreePrinter printer;
    public PrintAction(String name, Scanner scanner) {
        super(name, scanner);
    }

    @Override
    public void accept(Tree<T> tTree) {
        System.out.println("Entrou no PrintAction");
    }

    @Override
    public Consumer<Tree<T>> andThen(Consumer<? super Tree<T>> after) {
        return super.andThen(after);
    }
}
