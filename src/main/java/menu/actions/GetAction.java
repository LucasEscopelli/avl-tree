package menu.actions;

import menu.actions.abstractactions.Action;
import menu.terminalhandler.ConsoleHandler;
import menu.terminalhandler.UserInteractor;
import tree.Tree;

import java.util.Scanner;

public class GetAction extends Action<Tree<Integer>> {
    public GetAction(String name, Scanner scanner) {
        super(name, scanner);
    }

    @Override
    public ActionStatus runAction(Tree<Integer> tree) {
        printActionToDo();
        Integer node = UserInteractor.getIntegerValueFromUser(scanner, this::printActionToDo);
        Integer value = tree.get(node);
        if(value == null){
            System.out.println("Valor não encontrado");
            return ActionStatus.FAILED;
        }
        System.out.println("Valor "+value+" encontrado com sucesso");
        return ActionStatus.OK;
    }

    private void printActionToDo(){
        System.out.println("Digite o INTEIRO a se procurar na árvore.");
    }
}
