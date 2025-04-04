package menu.actions;

import menu.actions.abstractactions.Action;
import menu.terminalhandler.UserInteractor;
import tree.Tree;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class GetAction <T> extends Action<Tree<T>> {
    public GetAction(String name, Scanner scanner) {
        super(name, scanner);
    }

    @Override
    public void accept(Tree<T> tTree) {
        printActionToDo();
        Integer node = UserInteractor.getIntegerValueFromUser(scanner, this::printActionToDo);
        tTree.get((T) node);
    }

    @Override
    public Consumer<Tree<T>> andThen(Consumer<? super Tree<T>> after) {
        return super.andThen(after);
    }

    private void printActionToDo(){
        System.out.println("Digite o INTEIRO a se procurar na árvore.");
    }
}
