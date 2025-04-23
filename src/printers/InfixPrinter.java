package printers;

import printers.interfaces.TreePrinter;
import tree.BinaryTree;

public class InfixPrinter<C extends Comparable<C>> implements TreePrinter<C> {
    @Override
    public void print(BinaryTree<C> tree) {
        System.out.println("infix");
    }
}
