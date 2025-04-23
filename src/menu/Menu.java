package menu;

import menu.actions.*;
import menu.actions.abstractactions.Action;
import menu.terminalhandler.ConsoleHandler;
import menu.terminalhandler.UserInteractor;
import tree.BinaryTree;
import tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private ActionStatus actionStatus = ActionStatus.OK;
    private final List<Action<Tree<Integer>>> actions = new ArrayList<>();
    private final Tree<Integer> tree = new BinaryTree<>();
    private final Scanner scanner = new Scanner(System.in);

    public Menu(){
            actions.add(new CloseApplicationAction<>("Fechar aplicacao", scanner));
            actions.add(new AddAction("Adicionar Inteiro à árvore.", scanner));
            actions.add(new GetAction("Buscar valor na árvore.", scanner));
            actions.add(new RemoveAction("Remover valor da árvore.", scanner));
            actions.add(new PrintAction<>("Printar árvore.", scanner));
    }
    public void run() {
        while (actionStatus.equals(ActionStatus.OK)) {
            printActions();
            Integer choice = UserInteractor.getIntegerValueFromUser(scanner, this::printActions);
            ConsoleHandler.clearConsole();
            if (isInvalidChoice(choice)) {
                continue;
            }
            actionStatus = actions.get(choice).runAction(tree);
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
