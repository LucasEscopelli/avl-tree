package menu.actions;

import menu.actions.abstractactions.Action;
import menu.terminalhandler.ConsoleHandler;
import menu.terminalhandler.UserInteractor;
import model.Context;
import tree.Tree;

import java.util.Scanner;

public class GetAction extends Action<Context> {
    public GetAction(String name, Scanner scanner) {
        super(name, scanner);
    }

    @Override
    public ActionStatus runAction(Context tree) {
        printActionToDo();
        Integer node = UserInteractor.getIntegerValueFromUser(scanner, this::printActionToDo);
        return ActionStatus.OK;
    }

    private void printActionToDo(){
        System.out.println("Digite o INTEIRO a se procurar na árvore.");
    }
}
