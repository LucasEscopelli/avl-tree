package menu.actions;

import menu.actions.abstractactions.Action;
import menu.terminalhandler.UserInteractor;
import printers.AsciiPrinter;
import printers.InfixPrinter;
import printers.PosfixPrinter;
import printers.PrefixPrinter;
import printers.interfaces.TreePrinter;
import tree.BinaryTree;
import tree.Tree;

import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class PrintAction <T extends Comparable<T>> extends Action<Tree<T>> {
    private final List<Supplier<TreePrinter<T>>> printerOptions;

    public PrintAction(String name, Scanner scanner) {
        super(name, scanner);
        printerOptions = List.of(
                InfixPrinter::new,
                PrefixPrinter::new,
                PosfixPrinter::new,
                AsciiPrinter::new
        );
    }

    @Override
    public ActionStatus runAction(Tree<T> tree) {
        printPrinterOptions();
        int choice = UserInteractor.getIntegerValueFromUser(scanner, this::printPrinterOptions);

        if (isInvalidChoice(choice)) return ActionStatus.FAILED;

        TreePrinter<T> printer = printerOptions.get(choice - 1).get();
        printer.print((BinaryTree<T>) tree);

        return ActionStatus.OK;
    }

    private void printPrinterOptions() {
        System.out.println("Escolha o tipo de impressão:");
        for(int i=0;i<printerOptions.size();i++){
            System.out.println((i+1) + ". "+printerOptions.get(i).get().name());
        }
    }

    private boolean isInvalidChoice(int choice) {
        return choice < 1 || choice > printerOptions.size();
    }
}
