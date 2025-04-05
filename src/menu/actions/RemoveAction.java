package menu.actions;

import menu.actions.abstractactions.Action;
import menu.terminalhandler.UserInteractor;
import tree.Tree;

import java.util.Scanner;
import java.util.function.Consumer;

public class RemoveAction <T> extends Action<Tree<T>> {
    public RemoveAction(String name, Scanner scanner) {
        super(name, scanner);
    }

    @Override
    public void accept(Tree<T> tTree) {
        printActionToDo();
        Integer node = UserInteractor.getIntegerValueFromUser(scanner, this::printActionToDo);
        tTree.delete((T) node);
    }

    @Override
    public Consumer<Tree<T>> andThen(Consumer<? super Tree<T>> after) {
        return super.andThen(after);
    }

    private void printActionToDo(){
        System.out.println("Digite o INTEIRO a ser removido da árvore.");
    }
}
