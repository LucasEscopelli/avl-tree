package menu.actions;

import menu.actions.abstractactions.Action;
import menu.terminalhandler.ConsoleHandler;
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
    public ActionStatus runAction(Tree<T> tree) {
        printActionToDo();
        Integer node = UserInteractor.getIntegerValueFromUser(scanner, this::printActionToDo);
        T value = tree.get((T) node);
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
