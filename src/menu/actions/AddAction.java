package menu.actions;

import menu.actions.abstractactions.Action;
import menu.terminalhandler.UserInteractor;
import tree.Tree;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AddAction<T> extends Action<Tree<T>> {
    public AddAction(String label, Scanner scanner){
        super(label, scanner);
    }

    @Override
    public void accept(Tree<T> integerTree) {
        printActionToDo();
        Integer node = UserInteractor.getIntegerValueFromUser(scanner, this::printActionToDo);
        integerTree.add((T) node);
    }

    @Override
    public Consumer<Tree<T>> andThen(Consumer<? super Tree<T>> after) {
        return super.andThen(after);
    }

    private void printActionToDo(){
        System.out.println("Digite o INTEIRO a ser inserido na árvore.");
    }
}
