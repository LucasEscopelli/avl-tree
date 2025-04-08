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
    public ActionStatus runAction(Tree<T> tree) {
        printActionToDo();
        Integer node = UserInteractor.getIntegerValueFromUser(scanner, this::printActionToDo);
        tree.add((T) node);
        return ActionStatus.OK;
    }

    private void printActionToDo(){
        System.out.println("Digite o INTEIRO a ser inserido na árvore.");
    }
}
