package printers;

import printers.interfaces.TreePrinter;
import tree.BinaryTree;

public class PrefixPrinter<C extends Comparable<C>> implements TreePrinter<C> {
    @Override
    public void print(BinaryTree<C> tree) {
        System.out.println("prefix");
    }

    @Override
    public String name() {
        return "Prefix";
    }
}
