package menu;

import menu.actions.*;
import menu.actions.abstractactions.Action;
import menu.terminalhandler.ConsoleHandler;
import menu.terminalhandler.UserInteractor;
import model.Context;
import printers.StatisticsPrinter;
import tree.Statistics;

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
            actions.add(new LoadFileAction("Carregar arquivo", scanner));
            actions.add(new GetPersonByCpfAction("Pesquisar por cpf", scanner));
            actions.add(new GetPersonWithNamePrefixAction("Pesquisar por prefixo do nome", scanner));
            actions.add(new GetPersonBetweenDatesAction("Pesquisar por intervalo de nascimento", scanner));
    }
    public void run() {
        while (!actionStatus.equals(ActionStatus.CLOSE_APPLICATION)) {
            printActions();
            Integer choice = UserInteractor.getIntegerValueFromUser(scanner, this::printActions);
            ConsoleHandler.clearConsole();
            if (isInvalidChoice(choice)) {
                continue;
            }
            printChoice(choice);
            Statistics.getInstance().clear();
            actionStatus = actions.get(choice).runAction(ctx);
            StatisticsPrinter.printStatistics(Statistics.getInstance());
            printSeparator();
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
    private void printChoice(int choice){
        System.out.printf("Executando opção(%d): %s\n", choice, this.actions.get(choice).getName());
    }
    private void printSeparator(){
        System.out.println("-".repeat(50));
    }
}