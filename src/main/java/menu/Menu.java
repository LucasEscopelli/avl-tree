package menu;

import menu.actions.*;
import menu.actions.abstractactions.Action;
import menu.terminalhandler.ConsoleHandler;
import menu.terminalhandler.UserInteractor;
import model.Context;
import tree.BinaryTree;
import tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final List<Action<Context>> actions = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    Context ctx = new Context();
    private ActionStatus actionStatus = ActionStatus.OK;
    public Menu(){
            actions.add(new CloseApplicationAction<>("Fechar aplicacao", scanner));
            actions.add(new GetAction("Buscar valor na árvore.", scanner));
    }
    public void run() {
        while (!actionStatus.equals(ActionStatus.CLOSE_APPLICATION)) {
            printActions();
            Integer choice = UserInteractor.getIntegerValueFromUser(scanner, this::printActions);
            ConsoleHandler.clearConsole();
            if (isInvalidChoice(choice)) {
                continue;
            }
            actionStatus = actions.get(choice).runAction(ctx);
        }
    }
    private void printActions() {
        for(int i=0;i<actions.size();i++){
            System.out.println(i+". "+actions.get(i).getName());

        }
    }
    private boolean isInvalidChoice(int choice) {
        return choice < 0 || choice >= actions.size();
    }
}
