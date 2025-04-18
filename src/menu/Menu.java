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
            actions.add(new CloseApplicationAction<>("0. Fechar aplicacao", scanner));
            actions.add(new AddAction<>("1. Adicionar Inteiro à árvore.", scanner));
            actions.add(new GetAction<>("2. Buscar valor na árvore.", scanner));
            actions.add(new RemoveAction<>("3. Remover valor da árvore.", scanner));
            actions.add((new PrintAction<>("4. Printar árvore.", scanner)));
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
        actions.forEach(action -> System.out.println(action.getName()));
    }

    private boolean isInvalidChoice(int choice) {
        return choice < 0 || choice >= actions.size();
    }
}
