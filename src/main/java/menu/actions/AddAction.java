package menu.actions;

import menu.actions.abstractactions.Action;
import menu.terminalhandler.UserInteractor;
import tree.Tree;

import java.util.Scanner;

public class AddAction extends Action<Tree<Integer>> {
    public AddAction(String label, Scanner scanner){
        super(label, scanner);
    }

    @Override
    public ActionStatus runAction(Tree<Integer> tree) {
        printActionToDo();
        Integer node = UserInteractor.getIntegerValueFromUser(scanner, this::printActionToDo);
        tree.add(node);
        return ActionStatus.OK;
    }

    private void printActionToDo(){
        System.out.println("Digite o INTEIRO a ser inserido na árvore.");
    }
}
