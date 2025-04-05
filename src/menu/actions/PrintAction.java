package menu.actions;

import menu.actions.abstractactions.Action;
import menu.terminalhandler.ConsoleHandler;
import menu.terminalhandler.UserInteractor;
import printers.InfixPrinter;
import printers.PosfixPrinter;
import printers.PrefixPrinter;
import printers.interfaces.TreePrinter;
import tree.BinaryTree;
import tree.Tree;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

public class PrintAction <T> extends Action<Tree<T>> {
    private final List<Map.Entry<String, Supplier<TreePrinter>>> printerOptions;
    TreePrinter printer;

    public PrintAction(String name, Scanner scanner) {
        super(name, scanner);
        printerOptions = List.of(
                Map.entry("1. Infix", InfixPrinter::new),
                Map.entry("2. Prefix", PrefixPrinter::new),
                Map.entry("3. Postfix", PosfixPrinter::new)
        );
    }

    @Override
    public void accept(Tree<T> tree) {
        printPrinterOptions();
        int choice = UserInteractor.getIntegerValueFromUser(scanner, this::printPrinterOptions);

        ConsoleHandler.clearConsole();

        if (isInvalidChoice(choice)){
            accept(tree);
            return;
        }

        printer = printerOptions.get(choice - 1).getValue().get();
        printer.print((BinaryTree) tree);

    }

    private void printPrinterOptions() {
        System.out.println("Escolha o tipo de impressão:");
        printerOptions.forEach(printerOption -> System.out.println(printerOption.getKey()));
    }

    private boolean isInvalidChoice(int choice) {
        return choice < 1 || choice > printerOptions.size();
    }
}
