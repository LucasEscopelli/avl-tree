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
import java.util.function.Function;

public class Menu {
    private final List<Action<Tree<Integer>>> functions = new ArrayList<>();
    private final Tree<Integer> tree = new BinaryTree<>();
    private final Scanner scanner = new Scanner(System.in);

    public Menu(){
            functions.add(new CloseApplicationAction<>("0. Fechar aplicacao", scanner));
            functions.add(new AddAction<>("1. Adicionar Inteiro à árvore.", scanner));
            functions.add(new GetAction<>("2. Buscar valor na árvore.", scanner));
            functions.add(new RemoveAction<>("3. Remover valor da árvore.", scanner));
            functions.add((new PrintAction<>("4. Printar árvore.", scanner)));
    }

    public void menu() {
        while (true) {
            printFunctions();
            Integer choice = UserInteractor.getIntegerValueFromUser(scanner, this::printFunctions);
            ConsoleHandler.clearConsole();

            if (isInvalidChoice(choice)) {
                continue;
            }

            functions.get(choice).accept(tree);
        }
    }

    private void printFunctions() {
        functions.forEach(funcao -> System.out.println(funcao.getName()));
    }

    private boolean isInvalidChoice(int choice) {
        return choice < 0 || choice >= functions.size();
    }
}
